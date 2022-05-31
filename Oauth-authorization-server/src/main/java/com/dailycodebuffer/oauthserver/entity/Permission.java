package com.dailycodebuffer.oauthserver.entity;

import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Permission {
	
	private int permissionId;
	private String permissionName;
	private Set<Role> roles;
	public int getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
