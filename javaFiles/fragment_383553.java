//Save HashMap to Internal Storage
public void SaveHashMapToInternalStorage(String SavedData, LinkedHashMap<Integer, Integer> linkedHashMapList) {
    try{
        FileOutputStream fos = this.openFileOutput(SavedData, Context.MODE_PRIVATE);
        ObjectOutputStream s = new ObjectOutputStream(fos);
        s.writeObject(linkedHashMapList);
        s.close();

    }catch(Exception e){ }      
}

//Load HashMap from Internal Storage    @SuppressWarnings("unchecked")
public LinkedHashMap<Integer, Integer> LoadHashMapFromInternalStorage(String SavedData) {
    LinkedHashMap<Integer, Integer> linkedHashMapLIST = new LinkedHashMap<Integer, Integer>();
      try{
            FileInputStream fileInputStream = this.openFileInput(SavedData);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            linkedHashMapLIST = (LinkedHashMap<Integer, Integer>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

        }catch(Exception e){ }          
        return linkedHashMapLIST;
}