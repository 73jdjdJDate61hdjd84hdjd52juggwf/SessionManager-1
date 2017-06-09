package listener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import entity.User;
import util.SessionUtil;
@WebListener
public class MyServletRequestListener implements ServletRequestListener {

	private ArrayList<User>  userList;
	
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		
		userList = (ArrayList<User>)sre.getServletContext().getAttribute("userList");
		
		if(userList == null){
			userList = new ArrayList<User>();
		}
		
		HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
		String sessionIdString = req.getSession().getId();
		
		if(SessionUtil.getUserBySessionId(userList,sessionIdString)==null){
			User user = new User();
			user.setSessionIdString(sessionIdString);
			user.setFirstTime(new SimpleDateFormat("yyyyƒÍMM‘¬dd»’ HH:mm:ss").format(new Date()));
			user.setIpString(req.getRemoteAddr());
			userList.add(user);
		}
		sre.getServletContext().setAttribute("userList", userList);
	}

	

	

	
}
