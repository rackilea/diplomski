private void writeObject(Object obj, ObjectOutputStream oos) throws IOException
    {
        synchronized(oos)
        {
            oos.writeObject(obj);
            oos.flush();
            oos.reset();
        }
    }