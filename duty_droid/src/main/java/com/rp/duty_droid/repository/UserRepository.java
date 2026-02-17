package com.rp.duty_droid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rp.duty_droid.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    User findByMobileNo(String mobileNo);
    User findByUserId(Long userId);
}
