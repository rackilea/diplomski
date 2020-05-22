Class noparams[] = {};
        Class cls = Class.forName("com.test.Fruit");
        Object obj = cls.newInstance();

        //call the printIt method
        Method method = cls.getDeclaredMethod("apples", noparams);
        method.invoke(obj, null);