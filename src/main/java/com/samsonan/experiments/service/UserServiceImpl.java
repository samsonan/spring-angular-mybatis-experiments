package com.samsonan.experiments.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsonan.experiments.dao.UserMapper;
import com.samsonan.experiments.model.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserMapper userMapper;	
	
	public List<User> findAllUsers() {
		return userMapper.findAllUsers();
	}
	
	public User findById(long id) {
		return userMapper.findById(id);
	}
	
	public User findByName(String name) {
		return userMapper.findByName(name);
	}
	
	public void saveUser(User user) {
		userMapper.saveUser(user);
	}

	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	public void deleteUserById(long id) {
		userMapper.deleteUserById(id);
	}

	public boolean isUserExist(User user) {
		return findByName(user.getUserName())!=null;
	}
	
	public void deleteAllUsers(){
		userMapper.deleteAllUsers();
	}

}
