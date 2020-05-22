@Override
public boolean shouldFilter() {

    RequestContext ctx = RequestContext.getCurrentContext();

    if (ctx.getRequest().getRequestURI().equals("/test")) {
        return true;
    } else {
        return false;
    }
}