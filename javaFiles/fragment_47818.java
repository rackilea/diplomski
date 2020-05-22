public class Pojo {
    private String params;
    public void setParams(byte[] params) {
        try {
            this.params = new String(params, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            this.params = null;
        }
    }

}