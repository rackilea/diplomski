public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    ServletResponseWrapperCopier capturingResponseWrapper = new ServletResponseWrapperCopier(
                (HttpServletResponse) response);

    chain.doFilter(request, capturingResponseWrapper);
    try{
        String respopn = capturingResponseWrapper.getCaptureAsString();     
        JSONObject json=new JSONObject(respopn);
        JSONObject dMap=new JSONObject(json.get("dataMap"));
        dMap.put("new", "newValue");
        json.put("dataMap", dMap); // Modified the old datamap with new json
        JsonMapper jsonMap=new JsonMapper();
        jsonMap.setJson(json);
        String str=jsonMap.getJson();
        response.getOutputStream().write(str.getBytes());
    } catch(Exception e){
        log.error("");
    }
}