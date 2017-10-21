package com.mtl.control;

import com.mtl.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType(DBUtil.charset);
		
		String method = req.getParameter("method");
		Class clazz = this.getClass();
		System.out.println("clazz = " + clazz);
		try {
			Method method2 = clazz.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
			method2.invoke(this, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
