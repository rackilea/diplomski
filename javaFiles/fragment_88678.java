for(int i = 0; i < ALStore.size(); i++){
  if (i >= ALStore.size()) {
         ALStore.add(SA);
        }
    }
FileOutputStream fos = new FileOutputStream("C:\\Users\\MrCata\\Desktop\\Testingoutput.txt");
ObjectOutputStream oos = new ObjectOutputStream(fos);

oos.writeObject(ALStore);
fos.close();