public class CountScriptlet extends JRDefaultScriptlet {

    private static final String COUNT_FIELD = "fieldNameYouLikeToCount";

    //Map to hold our count and dataset
    private Map<String,CountResult> ds = new HashMap<String, CountResult>(); 

    @Override
    public void afterDetailEval() throws JRScriptletException
    {
        String key = (String)this.getFieldValue(COUNT_FIELD);
        CountResult cr = ds.get(key); //Check if we have it
        if (cr==null){
            cr = new CountResult(key); //No, then create it count = 0
            ds.put(key, cr);
        }
        cr.increment(); //Increment it (new 0-->1, old i-->i+1

    }   
    public JRBeanCollectionDataSource getDataSource(){
        return new JRBeanCollectionDataSource(ds.values()); //Return our class as datasource, if you need to sort'em use Collections
    }
}