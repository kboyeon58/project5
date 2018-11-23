package net.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.board.action.*;
import net.board.db.*;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();

		HttpSession session = request.getSession();
		BoardDAO boarddao = new BoardDAO();

		String Member_ID = request.getParameter("mb_id");
		System.out.println(Member_ID);
		String MEMBER_PW = request.getParameter("mb_password");

		if (boarddao.memberLogin(Member_ID, MEMBER_PW) == true) {
			System.out.println(Member_ID);
			forward.setRedirect(false);
			forward.setPath("main.jsp");
			System.out.println("11111111111111111111111111");
			System.out.println("idSession");
			session.setAttribute("idSession", Member_ID);
			return forward;
		} else {
			System.out.println("222222222222222222222222222222");
			forward.setRedirect(true);
			forward.setPath("loginForm.jsp");

			return forward;
		}
	}

}