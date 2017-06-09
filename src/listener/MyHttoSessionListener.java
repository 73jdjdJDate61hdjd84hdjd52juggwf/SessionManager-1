package listener;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import entity.User;
import util.SessionUtil;
@WebListener
public class MyHttoSessionListener implements HttpSessionListener {

	private int userNumber = 0;
	
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		userNumber++;
		se.getSession().getServletContext().setAttribute("userNumber", userNumber);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		userNumber--;
		se.getSession().getServletContext().setAttribute("userNumber", userNumber);
		
		ArrayList<User>  userList=null;
		
		userList = (ArrayList<User>)se.getSession().getServletContext().getAttribute("userList");
		
		if(SessionUtil.getUserBySessionId(userList, se.getSession().getId())!=null){
			userList.remove(SessionUtil.getUserBySessionId(userList, se.getSession().getId()));
		}
	}

	
}
