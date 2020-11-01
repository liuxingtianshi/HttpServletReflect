package com.zs.reflect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpReflectServlet extends HttpServlet {
    public HttpReflectServlet() {
        super();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("=============service方法=========");
        request.getRequestDispatcher("hello.jsp").forward(request, response);
    }
}
