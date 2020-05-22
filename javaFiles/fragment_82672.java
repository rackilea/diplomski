installBean();
try{
  chain.doFilter(req, resp);
}finally{
 Bean b = deinstallBean();
 useTheMetrics(b);
//potentially, process exception, etc
}