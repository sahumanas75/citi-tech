package com.cititech.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cititech.entity.Usermanagement;

@Repository
public class UserDAOImpl implements UserDAO {
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean checkEmailIdExist(String emailId) {
		boolean status;

		// first get the current session
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Usermanagement> theQuery = currentSession.createQuery("from Usermanagement us where  us.emailId=:emailId",
				Usermanagement.class);
		theQuery.setParameter("emailId", emailId);

		try {
			Usermanagement user = theQuery.uniqueResult();
			if (user != null) {
				status = true;
				return status;
			} else {
				status = false;
				return status;
			}

		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public void createNewUSer(Usermanagement usermanagement) {
		// first get the current session
		Session currentSession = sessionFactory.getCurrentSession();

		// save or update the customer
		currentSession.saveOrUpdate(usermanagement);

	}

	@Override
	public Usermanagement userAuthenticate(String userName, String password) {

		// first get the current session
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Usermanagement> theQuery = currentSession.createQuery(
				"from Usermanagement us WHERE us.userName=:userName AND us.password=:password", Usermanagement.class);
		theQuery.setParameter("userName", userName);
		theQuery.setParameter("password", password);

		Usermanagement user = theQuery.uniqueResult();
		try {
			if (user != null) {
				return user;
			} else {
				return user = null;
			}
		} catch (Exception e) {
			return user = null;
		}

	}

	@Override
	public Usermanagement getUserDetails(String userName) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Usermanagement> theQuery = currentSession.createQuery("from Usermanagement where userName=:userName",
				Usermanagement.class);
		theQuery.setParameter("userName", userName);
		Usermanagement usermanagement = theQuery.uniqueResult();
		return usermanagement;
	}

	@Override
	public boolean checkUsernameExist(String userName) {
		boolean status;

		// first get the current session
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Usermanagement> theQuery = currentSession
				.createQuery("from Usermanagement us where us.userName=:userName", Usermanagement.class);
		theQuery.setParameter("userName", userName);

		try {
			Usermanagement user = theQuery.uniqueResult();
			if (user != null) {
				status = true;
			} else {
				status = false;
			}

			return status;
		} catch (Exception e) {
			return false;
		}

	}

}
