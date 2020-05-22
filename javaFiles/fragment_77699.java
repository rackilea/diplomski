<%
//NEW LINES ADDED
String mainTabs = ParamUtil.getString( request, "mainTabs", "Categories" );
request.setAttribute( "mainTabs", mainTabs );

PortletURL postsUrlPaginator = renderResponse.createRenderURL();
postsUrlPaginator.setParameter( "currentID", Long.toString( currentID ) );
postsUrlPaginator.setParameter( "jspPage", "/admin/CLAdmin.jsp" );
postsUrlPaginator.setParameter( "mainTabs", "Categories" );
%>
//... additional code not shown