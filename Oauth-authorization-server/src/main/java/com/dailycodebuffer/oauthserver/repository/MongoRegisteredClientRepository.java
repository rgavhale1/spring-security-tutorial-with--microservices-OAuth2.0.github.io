package com.dailycodebuffer.oauthserver.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.TokenSettings;

import com.dailycodebuffer.oauthserver.entity.CustomRegisteredClient;
import com.mongodb.lang.Nullable;
//@Component
public class MongoRegisteredClientRepository implements RegisteredClientRepository {

	@Autowired
	CustomRegisteredClientRepository customRegisteredClientRepository;
	


	@Override
	public void save(RegisteredClient registeredClient) {

		customRegisteredClientRepository.save(new CustomRegisteredClient(registeredClient));

	}

	@Override
	@Nullable
	public RegisteredClient findById(String id) {

		Optional<CustomRegisteredClient> customRegisteredClient = customRegisteredClientRepository.findById(id);
		if (customRegisteredClient.isPresent()) {

			return customRegisteredClient.get().getRegisteredClient();
		} else {
			throw new RuntimeException("id not found");
		}

	}

	@Override
	@Nullable
	public RegisteredClient findByClientId(String clientId) {

		//Optional<CustomRegisteredClient> customRegisteredClient = customRegisteredClientRepository.findByClientId(clientId);
		
		List<CustomRegisteredClient> customRegisteredClients = customRegisteredClientRepository.findAll();


		Optional<CustomRegisteredClient> customRegisteredClient  =customRegisteredClients.stream().filter(x->x.getRegisteredClient().getClientId().equals(clientId)).findFirst();
		
		if (customRegisteredClient.isPresent()) {
			
			RegisteredClient registeredClient	=customRegisteredClient.get().getRegisteredClient();
			TokenSettings	tokenSettings= registeredClient.getTokenSettings();
			Map<String, Object> map =tokenSettings.getSettings();
			
			
			return RegisteredClient.from(registeredClient).tokenSettings(TokenSettings.builder().build()).build();
		} else {
			throw new RuntimeException("client_id not found");
		}
	}

}
