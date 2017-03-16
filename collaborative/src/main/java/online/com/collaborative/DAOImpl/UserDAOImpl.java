package online.com.collaborative.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import online.com.collaborative.DAO.UserDAO;
import online.com.collaborative.model.LoginUser;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static List<LoginUser> users;

	/* private AddressDAO addressDAO; */

	public List<LoginUser> list() {

		sessionFactory.getCurrentSession().createQuery("from LoginUser").getResultList();
		return null;
	}

	public LoginUser get(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(LoginUser.class, Integer.valueOf(id));
	}

	public boolean add(LoginUser user) {
		// TODO Auto-generated method stub

		sessionFactory.getCurrentSession().persist(user);
		return true;
	}

	public LoginUser getUserByUserName(String email) {
		// Session session = (Session) sessionFactory.getCurrentSession();
		return (LoginUser) sessionFactory.getCurrentSession()
				.createQuery("FROM LoginUser  WHERE emailId='" + email + "'").getSingleResult();

	}

	public boolean update(LoginUser loginUser) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(loginUser);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		LoginUser user = (LoginUser) sessionFactory.getCurrentSession().load(LoginUser.class, new Integer(id));
		if (user != null) {
			sessionFactory.getCurrentSession().delete(user);
		}

	}
	
	public void deleteAll()
	
	{
				users.clear();
	}
}
