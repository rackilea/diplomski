try {
    bos= new BufferedOutputStream (client.getOutputStream());
    bis= new BufferedInputStream (client.getInputStream());
    //writer=new BufferedWriter(new OutputStreamWriter(bos));
    reader=new BufferedReader(new InputStreamReader(bis));

    ObjectOutputStream oos=new ObjectOutputStream(bos);
    Profile P;

    while ((P = this.getProfile())!=null) {

        //writer.write(0);   //when the client receive a zero, e knows he will receive a profile
        //writer.flush();
        oos.write(0);
        oos.flush();
        oos.writeObject(P);
        oos.flush();
        System.out.println("clientprocessor : profile written (" + P.name + " " +P.id +")");
        int i=reader.read(); //Waiting to receive a one to be sure that the object was received
        System.out.println("clientprocessor : integer received : " +i);
    }

    System.out.println("--------clientprocessor : all profiles sent--------");
    //writer.write(1);   //when the client receive a one he knows he will not receive profiles anymore
    //writer.flush();
    oos.write(1);
    oos.flush();
}  catch (IOException e) {
    e.printStackTrace();
} finally {
    try {
        //writer.close();
        reader.close();
        bis.close();
        bos.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}