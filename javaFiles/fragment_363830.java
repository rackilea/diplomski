AppInfo ai = new AppInfo();     
    Preferences p = new Preferences();

    ai.setP(p);     
    p.setAi(ai);

    session.persist(ai);