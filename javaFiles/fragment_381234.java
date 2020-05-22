public class OutsourcableDeveloper<C> 
                 extends Developer<C> 
                 implements Rentable{

    /* This might not be needed if we don't need to extract C from taxes parameter */
   final Class<C> currencyClass;
   public OutsourcableDeveloper(Class<C> currencyClass){ this.currencyClass = currencyClass;}

   @Override
   public Rate<C> getRate(@SuppressWarnings("rawtypes") Taxes taxes){
        try{
            C taxesCurrency = (C) currencyClass.cast(taxes.getCurrency()); //IF actually needed getting the typed instance
            return new Rate<C>(taxesCurrency); //Or whatever processing
        } catch (ClassCastException e){
            throw new UnsupportedOperationException("OutsourcableDeveloper does not accept taxes in a currency that its not hims");
        }
   }
}