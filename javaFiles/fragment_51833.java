package tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class UserRoleTag extends TagSupport {
  private String roles;

  public int doStartTag() throws JspException {
    String userRole = (String)pageContext.getAttribute("currentUserRole");

    return roles.contains(userRole) ? EVAL_BODY_AGAIN : SKIP_BODY;
  }

  public String getRoles() {
    return roles;
  }

  public void setRoles(String roles) {
    this.roles = roles;
  }
}