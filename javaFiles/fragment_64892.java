@Component
public class CharacterEncodingZuulFilter extends ZuulFilter {


    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 10000;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();

        Map<String, String[]> qp = new HashMap<>();
        String s = "";
        try {
            s = ctx.getRequest().getQueryString().replaceAll("\\{", URLEncoder.encode("{", "UTF-8"));
            s = s.replaceAll("}", URLEncoder.encode("}", "UTF-8"));
            s = s.replaceAll("\\[", URLEncoder.encode("[", "UTF-8"));
            s = s.replaceAll("]", URLEncoder.encode("]", "UTF-8"));

            HttpServletRequest request = ctx.getRequest();

            CustomRequestWrapper wrapped = new CustomRequestWrapper(request, qp, s);

            ctx.setRequest(wrapped);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }
}