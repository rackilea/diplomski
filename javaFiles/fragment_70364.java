private String forwardPage; 

public String getForwardPage() { return forwardPage; }

public void setForwardPage(String forwardPage) {
  this.forwardPage = forwardPage;
} 

protected String getActionForward(FilterContext ctx, String key, boolean redirect) {
    HashMap filterForwards = ctx.getFilterForwards();
    String forwardPage = (String)filterForwards.get(key);
    if(forwardPage == null)
        return NONE;
    if (redirect) {
       setForwardPage(forwardPage);
       return "redirect";
    } else {
       setForwardPage(forwardPage)
       return SUCCESS; 
    }
}