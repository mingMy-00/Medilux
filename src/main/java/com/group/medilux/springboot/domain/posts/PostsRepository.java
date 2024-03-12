package com.group.medilux.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository<Posts> extends JpaRepository<Posts, Long> {

}
