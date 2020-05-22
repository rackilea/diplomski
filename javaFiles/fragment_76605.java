if(!esta) {
        Foo foo = new Foo(article);
        Thread th = new Thread(foo);
        try {
            th.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }