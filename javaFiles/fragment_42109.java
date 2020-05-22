static class MyResult extends Result {
    public void loginResult(Result loginAttempt) {
        System.out.println(new Gson().toJson(result));   
    }
}
...
this.callBack(new MyResult());