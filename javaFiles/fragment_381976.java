public static Transaction beginTransaction()
{

     return   session.beginTransaction();

}

public static void commitTransaction(Transaction transaction)
{
    try {
            transaction.commit();
        }

    } catch (Exception e) {
        if(transaction!=null)
            transaction.rollback();

        closeSession();
        e.printStackTrace();
    }       

}