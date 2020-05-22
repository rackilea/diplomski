void readerThread(final InputStreamReader tout)
{
    Thread read2 = new Thread(){
    @Override
    public void run(){
        StringBuilder line = new StringBuilder();
        char toAppend = ' ';
        try {
            while(true){
                try {
                    while (tout.ready()) {
                        toAppend = (char) tout.read();
                        if(toAppend == '\n')
                        {
                            System.out.print(line.toString());
                            line.setLength(0);
                        }
                        else
                            line.append(toAppend);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("\n\n\n************errorrrrrrr reading character**********\n\n\n");
                }
                Thread.sleep(1000);
            }
        }catch (Exception ex) {
            System.out.println(ex);
            try{
                tout.close();
            }
            catch(Exception e)
            {}
        }
    }
    };
    read2.start();
}