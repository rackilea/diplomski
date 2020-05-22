public void validate() {
   if(mode.equals("1")) {
       System.out.println("OK");
   } else {
    RequestContext context = RequestContext.getCurrentInstance();
    context.execute("PF('confirmButton').jq.click();");
   }
}