# HttpServletReflect
★ 面试题：一个请求发送到服务器，服务器是如何做出响应的？


HTML页面：<a href="hello">发送请求</a>

web.xml：

  <!-- 定义Servlet 服务 -->
      <servlet>
          <display-name>ReflectServlet</display-name>
          <servlet-name>ReflectServlet</servlet-name>
          <servlet-class>com.zs.reflect.HttpReflectServlet</servlet-class>
      </servlet>

  <!-- 定义请求映射 -->
      <servlet-mapping>
          <servlet-name>ReflectServlet</servlet-name>
          <url-pattern>/hello</url-pattern>
      </servlet-mapping>


Apache根据请求hello，解析xml获得<servlet-class>元素的Text，即字符串“com.zs.reflect.HttpReflectServlet”。

① 获得Class
		Class<?> c= Class.forName("org.wdl.servlet.HelloServlet");
② 获得响应的Servlet的实例
		Object obj = c.newInstance();
③ 调用Servlet实例的名称为“service”的Method
		Method method =c.getDeclaredMethod("service",HttpServletRequest.class,HttpServletResponse.class);
④ 调用方法，使用request对象和response对象做参数
	  注意：当请求到服务器的时候，服务器就会创建request对象和response对象。
	  method.invoke(obj,request,response);
