Runnable r2=new Runnable(){

    @Override
    public void run() 
    {

        try 
        {   lock.lock(); 
        System.out.println("Lock acquired in blockingMethod");
         System.out.println("about to wait");
         waitTillFilled.await();
         System.out.println("Waiting done....");
         Vector<String> newData=returnFields();
         System.out.println("added row is "+newData);
         model.addRow(newData);//add row
         System.out.println("Table created"+data);
            //invoke setName after reaquiring lock
            lock.unlock();
            System.out.println("Lock released in blockingMethod");
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }};