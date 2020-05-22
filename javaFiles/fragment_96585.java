public HashMap<String, Serializable> hashMapReader(java.io.File file){
    HashMap<String, Serializable> map2 = null;
    try{   
        FileInputStream f = new FileInputStream(file);  
        ObjectInputStream s = new ObjectInputStream(f);          
        map2 = (HashMap<String, Serializable>) s.readObject();
        f.close();
        s.close();
    } catch (IOException e) { 
        e.printStackTrace(); 
        return null;
    } catch (ClassNotFoundException c) {
        c.printStackTrace();
        return null;
    }
    return map2;
}

...
userAcc2 = otherClass.hashMapReader(new java.io.File(hashMapFile));