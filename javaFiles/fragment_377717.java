public void method1(){
    //..some code ...

    createUser(username, password, new SomeApiListener(){

        @Override
        public void exception(Throwable cause) {
            //handle exception...
        }

        @Override
        public void success(Response response) {
            //handle response ...
        }
    });
}