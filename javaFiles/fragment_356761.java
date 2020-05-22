for(int id: ids){

        Bill bill = null;

        Transaction tx = session.getTransaction();
        tx.begin();

        try{          
          bill= entityManager.find(Bill.class, id);

          if(bill.status() != pendingStatus ){
             System.out.println("The bill is already processed");
             tx.commit();
             continue;
          }

          bill.setStatus(processedStatus);
          entityManager.persist(bill);   

          session.flush();
          tx.commit();
        }catch(Exception e){
          tx.rollback();
          throw e;
        }
    }