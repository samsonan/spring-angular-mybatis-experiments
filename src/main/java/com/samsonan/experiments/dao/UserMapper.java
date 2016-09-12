package com.samsonan.experiments.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Options.FlushCachePolicy;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.samsonan.experiments.model.User;

public interface UserMapper {
	
	  @Insert("INSERT INTO users (username, address, email) VALUES"
	          + "(#{userName},#{address}, #{email})")
	  @Options(useGeneratedKeys=true, keyProperty="id", flushCache=FlushCachePolicy.TRUE, keyColumn="id")
	  public void saveUser(User user);

	  @Select("SELECT id, username as userName, address as address, email as email "
	          + "FROM users WHERE username = #{userName}")
	  public User findByName(String userName);	

	  @Select("SELECT id, username as userName, address as address, email as email "
	          + "FROM users WHERE id = #{id}")
	  public User findById(long id);	

	  @Select("SELECT id, username as userName, address as address, email as email FROM users")
	  public List<User> findAllUsers();
	  
	  @Delete("DELETE FROM users")
	  public void deleteAllUsers();
	  
	  @Delete("DELETE FROM users WHERE id = #{id}")
	  public void deleteUserById(long id);
	  
	  @Update("UPDATE users SET username = #{userName}, address = #{address}, email = #{email}"
	  		+ " WHERE id = #{id}")
	  public void updateUser(User user);
	  
}
