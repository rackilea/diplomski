void createInstanceOfClass(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException{


        Class classTemp = Class.forName(className);

        Object obj =classTemp.newInstance();



    }
}