package online.com.collaborative.DAO;

import java.util.List;


import online.com.collaborative.model.LoginUser;



public interface UserDAO {
	
	
	LoginUser get(int id);
	 boolean add(LoginUser loginUser);
	List<LoginUser> list();
	public LoginUser getUserByUserName(String name);
	 boolean update(LoginUser loginUser);
	 void delete(int id);
	 void deleteAll();

}
