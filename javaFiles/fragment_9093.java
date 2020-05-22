public void doGet( final HttpServletRequest request, final HttpServletResponse response ) throws ServletException, IOException 
{
    if ( isReloaded(request) ) handleReload( request, response );
    else handleNormal( request, response );
}

boolean isReloaded( final HttpServletRequest request )
{
    return request.getParameter("If-Modified-Since") == null;
}

/**
 * You may need to modify this function or you may not need it at all.
 * Let me know and I'll edit the solution.
 */
protected long getLastModified( final HttpServletRequest request )
{
    return new Date().getTime();
}