class AddExpiresHeaderResponse extends HttpServletResponseWrapper {

    public static final String[] CACHEABLE_CONTENT_TYPES = new String[] {
        "text/css", "text/javascript", "image/png", "image/jpeg",
        "image/gif", "image/jpg" };

    static {
        Arrays.sort(CACHEABLE_CONTENT_TYPES);
    }

    public AddExpiresHeaderResponse(HttpServletResponse response) {
        super(response);
    }

    @Override
    public void setContentType(String contentType) {
        if (contentType != null && Arrays.binarySearch(CACHEABLE_CONTENT_TYPES, contentType) > -1) {
            Calendar inTwoMonths = GeneralUtils.createCalendar();
            inTwoMonths.add(Calendar.MONTH, 2);

            super.setDateHeader("Expires", inTwoMonths.getTimeInMillis());
        } else {
            super.setHeader("Expires", "-1");
            super.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        }
        super.setContentType(contentType);
    }
}