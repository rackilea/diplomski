public Vendor getVendor(Vendor vendor, Boolean refresh) {
    Session session = HibernateUtil.getSession();

    session.setFlushMode(FlushMode.MANUAL);

        //refreshing the session here before the get call gave me the would still set some properties to null
        /*
        if(refresh.booleanValue()){
        session.refresh(vendor);
    }
    */

    vendor = vendor.get();

        //however putting the refresh here, after the get() call populated the vendor object properly
    if(refresh.booleanValue()){
        session.refresh(vendor);
    }
        ....
}