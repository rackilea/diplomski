<%@ taglib uri="/WEB-INF/user.tld" prefix="u" %>

<% pageContext.setAttribute("currentUserRole", "admin"); // this value would come from the controller... %>

<u:user roles="admin registered">
    welcome admin!
</u:user>

<u:user roles="guest">
    welcome guest!
</u:user>