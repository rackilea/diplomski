class ErrorBean{
   private String error;
   //getters and setters
}

ObjectMapper mapper = new ObjectMapper();
ErrorBeanerrorBean = new ErrorBean();
errorBean.setError ("Device cannot be null or empty.");
String json = mapper.writeValueAsString(errorBean);