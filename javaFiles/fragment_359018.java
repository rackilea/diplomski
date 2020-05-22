// Example object which implements Serializable 
Example example = new Example();

// Save an object 
ObjectOutput out = new ObjectOutputStream(new FileOutputStream(new File(getCacheDir(),"")+"cacheFile.srl"));
out.writeObject((Example) example);
out.close();


// Load in an object
ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(new File(getCacheDir(),"")+"cacheFile.srl")));
Example example_loaded = (Example) in.readObject();
in.close();