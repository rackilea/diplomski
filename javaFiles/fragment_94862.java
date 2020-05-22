public void run(){
        try{
            while(true){
                String line = input.readLine();

                if("EXIT".equals(line)){
                    clients.remove(this);
                    users.remove(name);
                    break;
                }else if(name.equals(line)){
                    System.out.println("OK");
                }
                boradcast(name, line); // method  of outer class - send messages to all
            }// end of while
        } // try
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    } // end of run()