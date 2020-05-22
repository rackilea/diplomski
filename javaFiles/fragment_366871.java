getResponse(url, activity, new Consumer<String>(){
            @Override
            public void accept(String s) {
                ReturnedString(s);
            }
        });