ObjectInputStream in = new ObjectInputStream(servletConnection.getInputStream());
MyRespObject myrespObj;
try
{
    myrespObj= (MyRespObject) in.readObject();
} catch (ClassNotFoundException e1)
{
    e1.printStackTrace();
}

in.close();