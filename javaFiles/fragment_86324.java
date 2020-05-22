TreeMap<YourKeyClass, YourValueClass> treeMap = 
             new TreeMap<>();
buildMyTree(treeMap);
FileOutputStream fout = new FileOutputStream("path/to/your/file.ser");
ObjectOutputStream oos = new ObjectOutputStream(fout);
oos.writeObject(treeMap);