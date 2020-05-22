FileInputStream ios = new FileInputStream("C:\\Users\\MrCata\\Desktop\\Testingoutput.txt");
 ObjectInputStream ois = new ObjectInputStream(ios);
 StoreAddress SAR = (StoreAddress)ois.readObject();
 ArrayList<StoreAddress> ALStore = (ArrayList)ois.readObject();
 for(int i = 0; i < ALStore.size(); i++){
    String list = ALStore.get(i).toString();

  }

 ios.close();