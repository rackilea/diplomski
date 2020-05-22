SessionMap session = (SessionMap) ActionContext.getContext().getSession();

//invalidate
session.invalidate();

//renew servlet session
session.put("renewServletSession", null);
session.remove("renewServletSession");

//populate the struts session
session.entrySet();