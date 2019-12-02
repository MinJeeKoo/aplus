package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.P_TurnoverDTO;
import model.service.UserManager_PT;
import model.service.UserNotFoundException;

public class ViewPTController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	
		UserManager_PT manager = UserManager_PT.getInstance();
		String userId = request.getParameter("userId");
		P_TurnoverDTO user = null;
		try {
			user = manager.findUser(userId);	// ����� ���� �˻�
		} catch (UserNotFoundException e) {				
	        return "redirect:/user/main_login/form";
		}	
		
		request.setAttribute("user", user);		// ����� ���� ����				
		return "/user/view_pt.jsp";				// ����� ���� ȭ������ �̵�
	}

}
