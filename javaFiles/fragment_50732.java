String[] portfolio = null;
if(null == request.getParameter("submit")) { //page reload, true
    portfolio = (String[])session.getAttribute("portfolio");
} else {
    portfolio = request.getParameterValues("portfolio");
    session.setAttribute("portfolio", portfolio);
}