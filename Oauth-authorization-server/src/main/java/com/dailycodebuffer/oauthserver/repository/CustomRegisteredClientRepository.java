package com.dailycodebuffer.oauthserver.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.oauthserver.entity.CustomRegisteredClient;
@Repository
public interface CustomRegisteredClientRepository extends MongoRepository<CustomRegisteredClient, String>{

	
	public Optional<CustomRegisteredClient>  findByClientId(String clientId);
}
