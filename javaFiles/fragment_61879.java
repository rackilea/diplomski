public void updatePrice (){
        EntityManager em = Persistence.createEntityManagerFactory("SystemCardiologyReportsPU").createEntityManager();
   List<Exams> examsList = em.createNamedQuery("Exams.findById").
         setParameter("id", this.selected.examId ).getResultList();
   this.selected.price == null ? null : examsList.get(0).getPrice();
}