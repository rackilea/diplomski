public int TotalTescase(String pattern, Class<?> testNGclass) throws ClassNotFoundException
    {

        int count = 0;

        testNGclass.getClass();
        Class<?> className = Class.forName(testNGclass.getName()); 

        Method[] methods = className.getMethods();

        for(int i=0; i<methods.length; i++)
        {
            String methodName = methods[i].getName();
            System.out.println("Method Name: "+methodName);

            if(methodName.contains(pattern))
            {
                count++;
            }
        }

        return count;

    }