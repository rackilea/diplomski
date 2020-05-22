public static class PhoneRequestWrapper extends HttpServletRequestWrapper {

    public PhoneRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        if (!("mobileNumber").equals(name)) {
            return super.getParameter(name);
        }
        String prefix = getParameter("phonePrefix");
        String mobileNumber = getRequest().getParameter("mobileNumber");
        if (StringUtils.isNotEmpty(prefix) && StringUtils.isNotEmpty(mobileNumber)) {
            return prefix + getRequest().getParameter("mobileNumber");
        } else {
            return mobileNumber;
        }
    }
}