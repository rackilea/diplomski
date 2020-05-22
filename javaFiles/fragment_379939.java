public void onButtonClick() {
    String url = "http://sampledomain.pl/test.php";
    String params = "";
    new Api(new Callback<String>() {
        @Override
        public void execute(String result) {
            changeText(result);
        }
    }).execute(url, params);
}