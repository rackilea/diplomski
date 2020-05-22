Runtime.getRuntime().addShutdownHook( //
            new Thread() {
                @Override
                public void run() {
                    System.out.println("Closing parser listener gracefully!");
                    context.close();
                }
            });