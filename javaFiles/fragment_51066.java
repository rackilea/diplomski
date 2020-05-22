class MyRunnable implements Runnable {

    List<String> resultSet;
    String str;

    public MyRunnable(String str, List<String> resultSet) {
        this.str = str;
        this.resultSet = resultSet;
    }

    @Override
    public void run() {
        System.out.println(str + "FIRST....");
        final String response = RESTInvoker.validateREST(JSONToPOJO .buildURL(str));
        System.out.println(response + "\t RESPONSE");
        resultSet.add(response);
    }

}