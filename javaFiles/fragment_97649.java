try {
    connexion.setTcpNoDelay(true);
    bos= new BufferedOutputStream (connexion.getOutputStream());
    bis= new BufferedInputStream (connexion.getInputStream());
    writer=new BufferedWriter(new OutputStreamWriter(bos));
    //reader=new BufferedReader(new InputStreamReader(bis));
    ObjectInputStream ois = new ObjectInputStream(bis);
    int k = ois.read();
    String S="clientconnexion  : profiles received : ";
    while (k==0){
        System.out.println("clientconnexion : waiting for an object to read");
        Profile P=(Profile)ois.readObject();
        S = S + P.name + " " + P.id+ " ; ";
        System.out.println(S);
        writer.write(1);//the client sends a 1 to the server (clientprocessor)
        writer.flush();
        k=ois.read();
    }
} catch (IOException e) {
    System.out.println(e);
    e.printStackTrace();
} catch (ClassNotFoundException e) {
    e.printStackTrace();
} finally {
    try {
        bis.close();
        bos.close();
        //reader.close();
        writer.close();
        System.out.println("clientconnexion : streams closed");
    } catch (IOException e) {
        e.printStackTrace();
    }
}