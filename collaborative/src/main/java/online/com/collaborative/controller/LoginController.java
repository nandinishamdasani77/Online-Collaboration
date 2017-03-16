package online.com.collaborative.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import online.com.collaborative.DAO.UserDAO;
import online.com.collaborative.model.LoginUser;

@RestController
public class LoginController implements Serializable {

	@Autowired
	UserDAO userDAO;

	@GetMapping("/allusers")
	public ResponseEntity<List<LoginUser>> listAllUsers() {
		List<LoginUser> users = userDAO.list();
		return new ResponseEntity<List<LoginUser>>(users, HttpStatus.OK);
	}

	@PostMapping("/adduser")

	public ResponseEntity<LoginUser> addUser(@RequestBody LoginUser loginUser)

	{
		return new ResponseEntity<LoginUser>(loginUser, HttpStatus.OK);
	}

	@PostMapping("/user/{id}")
	public ResponseEntity<LoginUser> updateUser(@PathVariable("id") int id, @RequestBody LoginUser loginUser) {
		LoginUser currentUser = userDAO.get(id);
		if (currentUser == null) {
			return new ResponseEntity<LoginUser>(HttpStatus.NOT_FOUND);
		} else {
			currentUser.setUserName(loginUser.getUserName());
			currentUser.setEmailId(loginUser.getEmailId());
			currentUser.setPassword(loginUser.getPassword());
			currentUser.setRole(loginUser.getRole());
			userDAO.update(currentUser);
			return new ResponseEntity<LoginUser>(currentUser, HttpStatus.OK);

		}
	}

	@GetMapping("user/{id}")
	public ResponseEntity<LoginUser> deleteUser(@PathVariable("id") int id) {
		LoginUser currentUser = userDAO.get(id);
		if (currentUser == null) {
			return new ResponseEntity<LoginUser>(HttpStatus.NOT_FOUND);
		} else {
			userDAO.delete(id);
			return new ResponseEntity<LoginUser>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/user")

	public ResponseEntity<LoginUser> deleteAllUsers() {
		userDAO.deleteAll();
		return new ResponseEntity<LoginUser>(HttpStatus.NO_CONTENT);
	}
}
