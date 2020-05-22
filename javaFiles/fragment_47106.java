lock.lock();
            System.out.println("Lock acquired in actionPerformed");
            try
            {
             System.out.println("Waiting to fill the sub form");
             model=(DefaultTableModel)table.getModel();
             Form newForm=new Form();
             lock.unlock();
             blockingMethod();
            } 
            finally
            {
             lock.unlock();
             System.out.println("Lock released in actionPerformed");
            }