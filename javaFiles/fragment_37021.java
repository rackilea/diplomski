try {
        doSomething(new TestCallback()  {
            @Override
            public void doCallback()  {
                throw new NullPointerException();
            }
        });
    } catch (Exception e) {
        System.out.println("Exception caught !!!");
    }