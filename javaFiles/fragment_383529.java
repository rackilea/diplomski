Form requestHeaders = (Form) this.getRequest().getAttributes().get("org.restlet.http.headers");

    boolean secure = false;
    if (requestHeaders.getValues("x-forwarded-proto") != null) {
        secure = requestHeaders.getValues("x-forwarded-proto").contains("https");
    }