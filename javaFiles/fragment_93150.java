MDC.put("id", "1");
    new Thread(){
        @Override
        public void run() {
            System.out.println(MDC.get("id"));  // prints 1
        }
    }.start();