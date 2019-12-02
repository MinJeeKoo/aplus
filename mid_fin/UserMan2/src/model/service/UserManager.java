package model.service;

import java.sql.SQLException;
import java.util.List;

import model.User_JobSeeker;
import model.dao.User_JobSeekerDAO;

/**
 * ����� ���� API�� ����ϴ� �����ڵ��� ���� �����ϰ� �Ǵ� Ŭ����.
 * UserDAO�� �̿��Ͽ� �����ͺ��̽��� ������ ���� �۾��� �����ϵ��� �ϸ�,
 * �����ͺ��̽��� �����͵��� �̿��Ͽ� �����Ͻ� ������ �����ϴ� ������ �Ѵ�.
 * �����Ͻ� ������ ������ ��쿡�� �����Ͻ� �������� �����ϴ� Ŭ������ 
 * ������ �� �� �ִ�.
 */
public class UserManager {
	private static UserManager userMan = new UserManager();
	private User_JobSeekerDAO userDAO;
	private UserAnalysis userAanlysis;

	private UserManager() {
		try {
			userDAO = new User_JobSeekerDAO();
			userAanlysis = new UserAnalysis(userDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static UserManager getInstance() {
		return userMan;
	}
	
	public int create(User_JobSeeker user) throws SQLException, ExistingUserException {
		if (userDAO.existingUser(user.getUserId()) == true) {
			throw new ExistingUserException(user.getUserId() + "�� �����ϴ� ���̵��Դϴ�.");
		}
		return userDAO.create(user);
	}

	public int update(User_JobSeeker user) throws SQLException {
		return userDAO.update(user);
	}	

	public int remove(String userId) throws SQLException {
		return userDAO.remove(userId);
	}

	public User_JobSeeker findUser(String userId)
		throws SQLException, UserNotFoundException {
		User_JobSeeker user = userDAO.findUser(userId);
		
		if (user == null) {
			throw new UserNotFoundException(userId + "�� �������� �ʴ� ���̵��Դϴ�.");
		}		
		return user;
	}

	public List<User_JobSeeker> findUserList() throws SQLException {
			return userDAO.findUserList();
	}
	
	public List<User_JobSeeker> findUserList(int currentPage, int countPerPage)
		throws SQLException {
		return userDAO.findUserList(currentPage, countPerPage);
	}

	public boolean login(String userId, String password)
		throws SQLException, UserNotFoundException, PasswordMismatchException {
		User_JobSeeker user = findUser(userId);

		if (!user.matchPassword(password)) {
			throw new PasswordMismatchException("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
		return true;
	}

//	public List<User_JobSeeker> makeFriends(String userId) throws Exception {
//		return userAanlysis.recommendFriends(userId);
//	}
	
	public User_JobSeekerDAO getUserDAO() {
		return this.userDAO;
	}
}
