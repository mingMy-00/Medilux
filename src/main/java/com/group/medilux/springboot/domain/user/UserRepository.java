package com.group.medilux.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //이미 가입한 회원인지 확인해주는 method
    Optional<User> findByEmail(String email);
}
