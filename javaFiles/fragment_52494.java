ObjectOutputStream objectOutputStream = ...;
objectOutputStream.writeInt(MyClass.nextmember);
// write your users

ObjectInputStream objectInputStream = ...;
MyClass.nextmember = objectInputStream.readInt()
// read your users