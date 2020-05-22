private String test1 = null;
private String test2 = null;

private AsyncCallback<GetArticleResult> callback = new AsyncCallback<GetArticleResult>() {
    @Override
    public void onFailure(Throwable throwable) {
        Window.alert(throwable.getClass().getName() + " - " + throwable.getMessage());
    }

    @Override
    public void onSuccess(GetArticleResult s) {
        test1 = s.msg;
        test2 = "123";
        Window.alert(test1 + " - " + test2);
    }
};

private class MyValueChangeHandler implements ValueChangeHandler<String> {
    @Override
    public void onValueChange(ValueChangeEvent<String> stringValueChangeEvent) {
        Window.alert(test1 + " - " + test2);
    }
}