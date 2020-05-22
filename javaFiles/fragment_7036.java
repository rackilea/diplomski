class GetStatusWrapper extends HttpServletResponseWrapper {

    private int status;

    GetStatusWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public void setStatus(int sc) {
        super.setStatus(sc);
        status = sc;
    }

    public int getStatus() {
        return status;
    }
}