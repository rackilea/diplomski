FileInputStream fis = new FileInputStream("somefile");
ObjectInputStream ois = new ObjectInputStream(fis);
Map<String, ArrayList<int[][]>> mresults = 
                          (HashMap<String, ArrayList<int[][]>>) ois.readObject();
ois.close();
fis.close();