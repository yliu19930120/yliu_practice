package com.yliu.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
/**
 * shiro的使用
 * @author YLiu
 * @Email yliu19930120@163.com
 * 2019年4月21日 上午10:20:25
 */
public class ShiroTest {
	
	private Subject currentUser;
	
	public static void main(String[] args) {
		ShiroTest test = new ShiroTest();
		test.init();
		test.Login();
	}
	
	
	private void init(){
		IniRealm realm = new IniRealm("classpath:shiro.ini");
		realm = new IniRealm();
				// 2。创建SecurityManager
				SecurityManager securityManager = new DefaultSecurityManager(realm);

				// 3。使其可访问
				SecurityUtils.setSecurityManager(securityManager);	
				
				 currentUser = SecurityUtils.getSubject();
	}
	private void Login(){
		AuthenticationToken token = new UsernamePasswordToken("jdoe", "123456");
		currentUser.login(token);
		System.out.println(currentUser.isAuthenticated());
	}
}
