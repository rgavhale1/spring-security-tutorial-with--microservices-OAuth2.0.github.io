package com.dailycodebuffer.oauthserver.entity;

import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
@Document
@Builder
public class Role {
	
	private int roleId;
	private String roleName;
	private Set<Permission> permissions;
	private Set<User> users;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Set<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	

}
