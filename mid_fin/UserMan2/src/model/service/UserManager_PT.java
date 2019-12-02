package model.service;

import java.sql.SQLException;
import java.util.List;

import model.P_TurnoverDTO;
import model.dao.P_TurnoverDAOImpl;
//pt(������)�� �α����Ҷ� �ʿ��� manager
public class UserManager_PT {
	private static UserManager_PT userMan = new UserManager_PT();
	private P_TurnoverDAOImpl userDAO;
	private UserAnalysis_PT userAanlysis;

	private UserManager_PT() {
		try {
			userDAO = new P_TurnoverDAOImpl();
			userAanlysis = new UserAnalysis_PT(userDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static UserManager_PT getInstance() {
		return userMan;
	}
	
	public int create(P_TurnoverDTO pt) throws SQLException, ExistingUserException {
		if (userDAO.existingUser(pt.getP_id()) == true) {
			throw new ExistingUserException(pt.getP_id() + "�� �����ϴ� ���̵��Դϴ�.");
		}
		return userDAO.create(pt);
	}

	public int update(P_TurnoverDTO user) throws SQLException {
		return userDAO.update(user);
	}	

	public int remove(String userId) throws SQLException {
		return userDAO.remove(userId);
	}

	public P_TurnoverDTO findUser(String userId)
		throws SQLException, UserNotFoundException {
		P_TurnoverDTO user = userDAO.findUser(userId);
		
		if (user == null) {
			throw new UserNotFoundException(userId + "�� �������� �ʴ� ���̵��Դϴ�.");
		}		
		return user;
	}

	public List<P_TurnoverDTO> findUserList() throws SQLException {
			return userDAO.findUserList();
	}
	
	public List<P_TurnoverDTO> findUserList(int currentPage, int countPerPage)
		throws SQLException {
		return userDAO.findUserList(currentPage, countPerPage);
	}

	public boolean login(String userId, String password)
		throws SQLException, UserNotFoundException, PasswordMismatchException {
		P_TurnoverDTO user = findUser(userId);

		if (!user.matchPassword(password)) {
			throw new PasswordMismatchException("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
		return true;
	}

//	public List<P_TurnoverDTO> makeFriends(String userId) throws Exception {
//		return userAanlysis.recommendFriends(userId);
//	}
	
	public P_TurnoverDAOImpl getUserDAO() {
		return this.userDAO;
	}

}
