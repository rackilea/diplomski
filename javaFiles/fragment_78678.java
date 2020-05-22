void saveBidders(ArrayList<Bidder> bidders, String file) throws IOException{

     ObjectOutputStream oos = new ObjectOutputStream(new File(file));
     oos.writeObject(bidders);
     oos.close();
 }

 ArrayList<Bidder> getBidders(String file) throws IOException{

     ObjectInputStream ois = new ObjectInputStream(new File(file));
     ArrayList<Bidder> bidders = (ArrayList<Bidder>) ois.readObject();
     ois.close();
     return bidders;
 }