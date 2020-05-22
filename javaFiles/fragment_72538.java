try {
 Conducteur c=new Conducteur(cin, nom, prenom, new Date(), permis, new Date());
 EntityManagerFactory emf=Persistence.createEntityManagerFactory("googleApiPU");//EM
 ConducteurJpaController cjc=new ConducteurJpaController(emf);// JPA controller
 cjc.create(c);//persist
}
catch(Exception e)
{
 e.printStackTrace();
}