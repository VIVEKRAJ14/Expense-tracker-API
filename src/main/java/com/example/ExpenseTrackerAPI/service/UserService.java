package com.example.ExpenseTrackerAPI.service;

import com.example.ExpenseTrackerAPI.model.AuthenticationToken;
import com.example.ExpenseTrackerAPI.model.User;
import com.example.ExpenseTrackerAPI.model.dto.SignInInput;
import com.example.ExpenseTrackerAPI.model.dto.SignUpOutput;
import com.example.ExpenseTrackerAPI.repo.IAuthTokenRepo;
import com.example.ExpenseTrackerAPI.repo.IUserRepo;
import com.example.ExpenseTrackerAPI.service.utility.EmailHandler;
import com.example.ExpenseTrackerAPI.service.utility.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;
    @Autowired
    IAuthTokenRepo authTokenRepo;

    public SignUpOutput signUpUser(User user) {
        boolean signUpStatus = true;
        String signUpStatusMessage = null;

        String newEmail = user.getEmail();

        if(newEmail == null)
        {
            signUpStatusMessage = "Invalid email";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        User existingUser = userRepo.findFirstByEmail(newEmail);

        if(existingUser != null)
        {
            signUpStatusMessage = "Email already registered!!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(user.getPassword());

            //saveAppointment the patient with the new encrypted password

            user.setPassword(encryptedPassword);
            userRepo.save(user);

            return new SignUpOutput(signUpStatus, "User registered successfully!!!");
        }
        catch(Exception e)
        {
            signUpStatusMessage = "Internal error occurred during sign up";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }
    }

    public String signInUser(SignInInput signInInput) {
        String signInStatusMessage = null;

        String signInEmail = signInInput.getEmail();

        if(signInEmail == null)
        {
            signInStatusMessage = "Invalid email";
            return signInStatusMessage;


        }

        //check if this patient email already exists ??
        User existingUser = userRepo.findFirstByEmail(signInEmail);

        if(existingUser == null)
        {
            signInStatusMessage = "Email not registered!!!";
            return signInStatusMessage;

        }

        //match passwords :

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());
            if(existingUser.getPassword().equals(encryptedPassword))
            {
                //session should be created since password matched and user id is valid
                AuthenticationToken authToken  = new AuthenticationToken(existingUser);
                authTokenRepo.save(authToken);

                EmailHandler.sendEmail(signInEmail,"email testing",authToken.getTokenValue());
                return "Token sent to your email";
            }
            else {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }
        }
        catch(Exception e)
        {
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }
    }

    public String sigOutUser(String email) {
        User user = userRepo.findFirstByPatientEmail(email);
        authTokenRepo.delete(authTokenRepo.findFirstByUser(user));
        return "User Signed out successfully";
    }

    public List<User> getAllUser() {
        return userRepo.findAll();
    }
}
