public void writetoport(String send) {

    try {
            out1.write(send.getBytes());
            out1.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
}