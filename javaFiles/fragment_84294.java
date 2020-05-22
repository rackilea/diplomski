MyClass[][] objects = new MyClass[4096][4096];
    for(int i = 0;i<4096;i++)
    {
        for(int j = 0;j<4096;j++)
        {
            objects[i][j] = new MyClass();

        }
    }

    Thread.sleep(1000000);
    System.out.println(objects[10][40]);