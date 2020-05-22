// assuming this code is part of a Servlet or JSP
HttpServletRequest request = ...;
final Map<String,String> additionalParameters = ...;

RequestDispatcher dispatcher = this.getServletConfig().getServletContext().getRequestDispatcher("/");

dispatcher.forward(new HttpServletRequestWrapper(request){

    public String getRequestParameter(String parameterName) {
        if (additionalParameters.contains(parameterName)) {
           return additionalParameters.get(parameterName);
        } else {
           if (!"filteredParameter".equals(parameterName)) {
              return super.getParameterMap().get(parameterName());
           } else {
              return null;
           } 
        }
    }
}
, response);