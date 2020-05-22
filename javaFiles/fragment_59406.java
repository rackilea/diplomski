<Service-Component>
  com.mycompany.MyServlet1;
    provide:=javax.servlet.http.HttpServlet;immediate:=true;
    http=org.osgi.service.http.HttpService,
  com.mycompany.MyServlet2;
    provide:=javax.servlet.http.HttpServlet;immediate:=true;
    http=org.osgi.service.http.HttpService
 </Service-Component>