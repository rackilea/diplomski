package com.jenkov.seo.web;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class MaintenanceModeFilter
    implements Filter
{

    public MaintenanceModeFilter()
    {
        mode = 0;
        maintenanceUrl = null;
        maintenanceGuiUrl = null;
        password = null;
        comment = null;
    }

    public void init(FilterConfig filterconfig)
        throws ServletException
    {
        maintenanceUrl = filterconfig.getInitParameter("maintenanceUrl");
        maintenanceGuiUrl = filterconfig.getInitParameter("maintenanceGuiUrl");
        password = filterconfig.getInitParameter("password");
    }

    public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain filterchain)
        throws IOException, ServletException
    {
        HttpServletRequest httpservletrequest = (HttpServletRequest)servletrequest;
        if(servletrequest.getParameter("maintenance-mode") != null)
        {
            if(password.equals(servletrequest.getParameter("password")))
            {
                mode = Integer.parseInt(servletrequest.getParameter("maintenance-mode"));
                comment = servletrequest.getParameter("aComment");
                servletrequest.getRequestDispatcher(maintenanceGuiUrl).include(servletrequest, servletresponse);
            }
            return;
        }
        if(mode != 0 && !httpservletrequest.getServletPath().equals(maintenanceGuiUrl))
        {
            servletrequest.setAttribute("comment", comment);
            servletrequest.getRequestDispatcher(maintenanceUrl).include(servletrequest, servletresponse);
            return;
        } else
        {
            filterchain.doFilter(servletrequest, servletresponse);
            return;
        }
    }

    public void destroy()
    {
    }

    public static final int MODE_NORMAL_OPERATION = 0;
    protected int mode;
    protected String maintenanceUrl;
    protected String maintenanceGuiUrl;
    protected String password;
    protected String comment;
}