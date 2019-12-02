package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.P_TurnoverDTO;
import model.service.UserManager_PT;

public class MainLoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
    	String currentPageStr = request.getParameter("currentPage");	
		int currentPage = 1;
		if (currentPageStr != null && !currentPageStr.equals("")) {
			currentPage = Integer.parseInt(currentPageStr);
		}		
    	
    	
		UserManager_PT manager = UserManager_PT.getInstance();
		List<P_TurnoverDTO> userList = manager.findUserList();
//		List<P_TurnoverDTO> userList = manager.findUserList(currentPage, countPerPage);

		// userList ��ü�� ���� �α����� ����� ID�� request�� �����Ͽ� ����
		request.setAttribute("userList", userList);				
		request.setAttribute("curUserId", 
				UserSessionUtils.getLoginUserId(request.getSession()));		

		// ����� ����Ʈ ȭ������ �̵�(forwarding)
		return "/user/main_afterLogin.jsp";
	}

}
