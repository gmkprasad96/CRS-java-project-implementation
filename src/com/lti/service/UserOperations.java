/**
 * 
 */
package com.lti.service;

import java.util.HashMap;
import java.util.Map;

import com.lti.bean.User;
import com.lti.exception.UserNotFoundException;

/**
 * @author user252
 *
 */
public class UserOperations implements UserInterface{
	
	public boolean doLogin(User login) throws UserNotFoundException{
		
		String userName = login.getUserName();
		String password = login.getPassword();
		String role = login.getRole();
		
		Map<String,String> adminCredentials = new HashMap<>();
		Map<String,String> studentCredentials = new HashMap<>();
		Map<String,String> professorCredentials = new HashMap<>();
		
		adminCredentials.put("admin@gmail.com", "admin");
		studentCredentials.put("student@gmail.com", "student");
		professorCredentials.put("professor@gmail.com","professor");
		
		if("Admin".equals(role)){
			if(adminCredentials.containsKey(userName) && adminCredentials.get(userName).equals(password)){
					return true;
			}
		}else if("Student".equals(role)){
			if(studentCredentials.containsKey(userName) && studentCredentials.get(userName).equals(password)){
				return true;
			}	
		}else if("Professor".equals(role)){
			if(professorCredentials.containsKey(userName) && professorCredentials.get(userName).equals(password)){
				return true;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.lti.service.UserInterface#updatePassword()
	 */
	@Override
	public void updatePassword() {
		// TODO Auto-generated method stub
		
	}
	
}
