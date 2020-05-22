@Override
public void doFilter(final ServletRequest request, final ServletResponse response, FilterChain chain) throws IOException, ServletException {
    chain.doFilter(request,response);
    try{
        Base.open();
        Base.openTransaction();
        chain.doFilter(request, response);
        Base.commitTransaction();
    }
    catch (IOException e){
        Base.rollbackTransaction();
        throw e;
    }
    catch (ServletException e){
        Base.rollbackTransaction();
        throw e;
    }
    finally{
        Base.close();
    }
}