package com.group.medilux.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;;


@Repository
public interface PostsRepository<Posts> extends JpaRepository<Posts, Long> {

}
