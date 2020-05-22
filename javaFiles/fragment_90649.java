FileNotFoundException fileNotFoundException= new FileNotFoundException();
        IOException ioException = new IOException();
        //ObjectStreamException objectStreamException = null;
        ClassNotFoundException classNotFoundException= new ClassNotFoundException();
        //FileFormatException FileFormatException;
        NoSuchFieldException noSuchFieldException  = new NoSuchFieldException();

        exceptionHashtable.put("e1", fileNotFoundException); 
        exceptionHashtable.put("e2", ioException); 
        //exceptionHashtable.put("e3", objectStreamException); 
        exceptionHashtable.put("e4", classNotFoundException); 
        //exceptionHashtable.put("e5", FileFormatException); 
        exceptionHashtable.put("e6", noSuchFieldException); 


        System.out.println("The Hashtable is:" + exceptionHashtable);