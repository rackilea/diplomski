public enum QueryParams{
      PARAM_1("param1"),
      PARAM_2("param2"),

      private String paramValue;
      QueryParams(String paramName){
        this.paramValue = paramValue();
      }
      public void getParamValue(){
         return this.value;
      }
}