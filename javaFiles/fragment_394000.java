public void nbreRep(ActionEvent e){
List<Object[]> results;  
List<Object[]>dateObj=new ArrayList<Object[]>() ; 
Date date_de;
Date date_a;
Calendar beginCalendar = Calendar.getInstance();
    Calendar finishCalendar = Calendar.getInstance();
    beginCalendar.setTime(date_de);
    finishCalendar.setTime(date_a);
    while (beginCalendar.before(finishCalendar)) {

        Date datediff = beginCalendar.getTime();
        beginCalendar.add(Calendar.MONTH, 1);
         fC = Calendar.getInstance();
        Calendar fCa = Calendar.getInstance();
        fC.setTime(datediff);
        fCa.setTime(datediff);
        int year = fCa.get(Calendar.YEAR);
        String d=fC.getDisplayName(fC.MONTH, fC.LONG, Locale.FRANCE )+" "+year;
        Object[] obj = new Object[2];
        obj[0] = d;
        obj[1] = 1;
 dateObj.add(obj);
    } 
    Query query=entityManager.createQuery("select r.dateheurerep,count(r) as nbrr "+"  from Reparation r where r.dateheurerep >= :date_de and r.dateheurerep <= :date_a GROUP BY YEAR(r.dateheurerep),MONTH(r.dateheurerep)");
    query.setParameter("date_de", date_de);
    query.setParameter("date_a", date_a);
    results = query.getResultList( );
    results.addAll(dateObj);
 }