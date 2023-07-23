package com.example.ExpenseTrackerAPI.repo;

import com.example.ExpenseTrackerAPI.model.AuthenticationToken;
import com.example.ExpenseTrackerAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthTokenRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByUser(User user);
}
