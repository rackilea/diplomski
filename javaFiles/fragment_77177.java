@RequestMapping(path="/api/v1/{messages}" , method=RequestMethod.POST)
  public void wrapper2(HttpServletRequest request, HttpServletResponse response, @PathVariable String messages) throws Exception{
      request = new PathInfoRequestWrapper(request, messages);
      context.getNamedDispatcher("CamelServlet").forward(request, response);

  }

  class PathInfoRequestWrapper extends HttpServletRequestWrapper{
    private String pathInfo;

    public PathInfoRequestWrapper(HttpServletRequest request, String pathInfo) {
       super(request);
       this.pathInfo = pathInfo;
    }

    @Override
    public String getPathInfo(){
        String origPathInfo = super.getPathInfo();
        if(origPathInfo == null || origPathInfo.equals("")){
            return this.pathInfo;
        }else{
            return origPathInfo;
        }
    }
  }