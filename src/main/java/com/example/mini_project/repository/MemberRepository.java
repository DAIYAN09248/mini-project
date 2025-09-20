package com.example.mini_project.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mini_project.model.Member;

@Repository
public interface MemberRepository extends MongoRepository<Member, String> {
}