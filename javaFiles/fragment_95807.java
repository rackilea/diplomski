while(true){
    klijent=new Client();
    udp=new Udp();

    klijent=udp.packageIN();
    if(klijent!=null){
        frame.statLabel.setText("");
        String str=new String(klijent.getBajt(),0,klijent.bajt.length);
        str=str.trim();
        frame.statLabel.setText(str+"@...@"+klijent.clientAddress.toString()+":"+klijent.clientPort+"-->Duljina:"+klijent.bajt.length);
    }
}