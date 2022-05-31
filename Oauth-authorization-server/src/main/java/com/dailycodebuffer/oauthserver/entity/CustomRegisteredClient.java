package com.dailycodebuffer.oauthserver.entity;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.config.ClientSettings;
import org.springframework.security.oauth2.server.authorization.config.TokenSettings;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Document
@Data
@NoArgsConstructor
public class CustomRegisteredClient extends RegisteredClient{
	
	private RegisteredClient registeredClient;
	
	
	public CustomRegisteredClient(RegisteredClient registeredClient) {
		super();
		this.registeredClient = registeredClient;
	}
	
	
	public RegisteredClient getRegisteredClient(){
		return registeredClient;
		
	}
	
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.getId();
	}

	@Override
	public String getClientId() {
		// TODO Auto-generated method stub
		return this.getClientId();
	}

	@Override
	public Instant getClientIdIssuedAt() {
		// TODO Auto-generated method stub
		return this.getClientIdIssuedAt();
	}

	@Override
	public String getClientSecret() {
		// TODO Auto-generated method stub
		return this.getClientSecret();
	}

	@Override
	public Instant getClientSecretExpiresAt() {
		// TODO Auto-generated method stub
		return this.getClientSecretExpiresAt();
	}

	@Override
	public String getClientName() {
		// TODO Auto-generated method stub
		return this.getClientName();
	}

	@Override
	public Set<ClientAuthenticationMethod> getClientAuthenticationMethods() {
		// TODO Auto-generated method stub
		return this.getClientAuthenticationMethods();
	}

	@Override
	public Set<AuthorizationGrantType> getAuthorizationGrantTypes() {
		// TODO Auto-generated method stub
		return this.getAuthorizationGrantTypes();
	}

	@Override
	public Set<String> getRedirectUris() {
		// TODO Auto-generated method stub
		return this.getRedirectUris();
	}

	@Override
	public Set<String> getScopes() {
		// TODO Auto-generated method stub
		return this.getScopes();
	}

	@Override
	public ClientSettings getClientSettings() {
		// TODO Auto-generated method stub
		return this.getClientSettings();
	}

	@Override
	public TokenSettings getTokenSettings() {
		Map<String, Object> map = new HashMap<>();

		map.put("settings#token#reuse-refresh-tokens", true);
		map.put("settings#token#id-token-signature-algorithm", "RS256");
		
	
			
			map.put("settings#token#access-token-time-to-live", Duration.ofMinutes(5));
			map.put("settings#token#refresh-token-time-to-live", Duration.ofHours(1));
			//map.put("settings#token#refresh-token-time-to-live", "PT1H");
		/*map.put("settings#token#access-token-time-to-live", "PT5M");
		map.put("settings#token#refresh-token-time-to-live", "PT1H");*/

		return TokenSettings.withSettings(map).build();
		
		
		// TODO Auto-generated method stub
	//	return this.getTokenSettings();
	}

}
