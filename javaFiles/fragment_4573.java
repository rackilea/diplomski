public static void main(String[] args) throws Exception {
    CustomBean customBean = new CustomBean();
    customBean.error = "FULL ERROR";
    customBean.status = "success";
    Gson gson = new Gson();
    System.out.println(gson.toJson(customBean));
}

public static class CustomBean {
    private String status;
    private String error;
}