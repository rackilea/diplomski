ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
Object obj = in.readObject();
MyWrapedData wraped = null;
if ((obj != null) && (obj instanceof MyWrappedData))
    wraped = (MyWrapedData)obj;
// get the specific elements from the wraped object