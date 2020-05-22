Thread fileWatcher = new Thread(new Runnable(){

            @Override
            public void run() {

                    System.out.println(msg.get(1)+"*******************");
                    try {

                        String result = "Hello";
                        System.out.println("Before Sending Message *******************");
                        getSender().tell(result, getSelf());