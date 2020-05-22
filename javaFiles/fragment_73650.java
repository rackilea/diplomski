import org.apache.struts.action.ActionRedirect;
...
ActionForward forward = action.forward("action_name");
ActionRedirect redirect = new ActionRedirect(forward);
redirect.addParameter("color", "red");
return redirect;