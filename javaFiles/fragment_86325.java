//initialize your socket 
//start listening on your socket
TreeMap<YourKeyClass, YourValueClass> treeMap = new TreeMap<>();
buildMyTree(treeMap);
ObjectOutputStream oos = new ObjectOutputStream(socketToClient.getOutputStream());
oos.writeObject(treeMap);