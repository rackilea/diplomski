List<Vaccine> allVaccines = new ArrayList<>();
for (People p : p1)
{
    Date dt1=p.getDob();

    Date date = new Date();
    long diff=date.getTime() - dt1.getTime();
    long diffDays = diff / (24 * 60 * 60 * 1000);
    double age = (double) diffDays/365;

    List vaccines=vaccineDao.getVaccine(age);
    allVaccines.addAll(vaccines);

}

 models.put( "myVaccines", allVaccines);