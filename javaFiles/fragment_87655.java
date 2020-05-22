public static void main(String args[])
    {
        Sample first = new Sample();
        first.setData(1);
        //Either
        //Sample second = new Sample();
        //second.setData(1);
        //or 
        Sample second = first;

        System.out.println(first.getData());  // 1
        System.out.println(second.getData()); // here, you will get 1 after above changes made.
    }