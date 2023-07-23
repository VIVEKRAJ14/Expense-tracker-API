package com.example.ExpenseTrackerAPI.repo;

import com.example.ExpenseTrackerAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {
    User findFirstByEmail(String newEmail);

    User findFirstByPatientEmail(String email);
}
