AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
final Map attributes = principal.getAttributes();

JSONObject jsonObj = new JSONObject(attributes);

PrintWriter out = response.getWriter();

response.setContentType("application/json");
response.setCharacterEncoding("UTF-8");

out.print(jsonObj);