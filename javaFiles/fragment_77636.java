String servletPath = request.getServletPath();

if (servletPath.equals("/JSFViews/index.xhtml") || servletPath.startsWith(ResourceHandler.RESOURCE_IDENTIFIER))
    chain.doFilter(request, response);
else
    resp.sendRedirect(request.getContextPath() + "/JSFViews/Login.xhtml");