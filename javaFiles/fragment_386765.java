hbsession = HibernateUtil.getCurrentSession();
    tx = hbsession.beginTransaction();
    for(int index = 0; index < 20; ++index){

    TestHBDemo obj = new TestHBDemo();
    //setting data

        hbsession.save(d5campaingObj);
        if(index == 9){
            hbsession.flush();
            hbsession.clear();
        }
        if(index == 14){
            hbsession.clear();               
        }
    }
tx.commit();