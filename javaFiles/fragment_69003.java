public InputStream getBody() throws IOException {
    if (isFormSubmittal(this.servletRequest)) {
        return getFormBody(this.servletRequest);
    }
    else {
        return this.servletRequest.getInputStream();
    }
}