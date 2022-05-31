package com.dailycodebuffer.oauthserver.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.oauthserver.entity.User;
@Repository
public interface UserRepository extends MongoRepository<User, ObjectId>{
	
 User findByUserName(String userName);
}
