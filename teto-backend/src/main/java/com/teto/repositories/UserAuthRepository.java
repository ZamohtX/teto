package com.teto.repositories;

import com.teto.domain.user.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserAuthRepository extends JpaRepository<UserAuth, String> {
    UserDetails findByLogin(String login);

    String login(String login);
}
