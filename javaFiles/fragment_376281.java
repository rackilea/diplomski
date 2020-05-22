encoder.setExceptionListener(new ExceptionListener() {
        @Override
        public void exceptionThrown(Exception e) {
            System.out.println("got exception. e=" + e);
            e.printStackTrace();
        }
    });