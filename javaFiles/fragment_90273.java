Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        while (!Thread.interrupted()) {
                            System.out.println(input.nextLine());
                        }
                    }

                });
                thread.start();

                while (true) 
                {
                    String text = in.nextLine();
                    output.println(text);
//                String nextInput = input.nextLine();
                    ......................
                }