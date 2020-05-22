private class ClientThread extends Thread{
    Socket s;
    Scanner sc;
    PrintWriter pw;

    ClientThread(Socket s){
        this.s = s;
    }

    @Override
    public void run() {
        try{
            String in,out;

            sc = new Scanner(s.getInputStream());
            pw = new PrintWriter(s.getOutputStream(), true);
            int i=0;
            do{
                in = sc.nextLine();
                System.out.println("In: " + in);
                int tmp = Integer.parseInt(in)+1;
                out = Integer.toString(tmp);
                pw.println(out);
                i++;
            }while(i<10);
        }catch(Exception e){}
    }
}