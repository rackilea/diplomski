while( (bs=Bbr.readLine()) != null ){
    String[] Ust=bs.split("   ");
    String Bname=Ust[0];
    String Bdate=Ust[1];
    String id = Ust[2];
    if (id.equals(bookid.trim()) // only compare Id's + you should always trim user input
        jLabel1.setText("Book Found,    "+ Bname + "    " + Bdate);
        break;
    }
}