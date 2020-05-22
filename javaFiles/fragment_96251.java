public class NumberService{

        //Inject by DI containers , or setter / constructor
        NumberDAO numberDAO;

         public void incrementNumber(long id , int increaseAmount) throws Exception{

                Number n = (Number) numberDAO.loadById(id);

                if (XXXXXXXX) 
                    throws new IllegalArgumentException("BLAH BLAH BLAH BLAH");

                n.setNumber(n.getNumber() +increaseAmount);
         }

}