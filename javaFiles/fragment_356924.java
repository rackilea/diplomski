@Test
public void test(){

    Resources res = serviceFactory.getApplicationContext().getResources();

    Log.d(TAG, "default language: "+ getStringResourceByName(res,"LG")); //will print the default definition.

    Configuration conf = res.getConfiguration();
    conf.locale = Locale.FRENCH; //for instance
    res.updateConfiguration(conf, null); //

    Log.d(TAG, "French: "+ getStringResourceByName( res,"LG"));//will print definition of LG in french resource file

}