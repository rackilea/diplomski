public class YourAction {

    private List<Object> levelList; // private
    private List<Object> subjectList; // private

    public String execute() throws Exception {      
            Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session2.beginTransaction();
            Query q = session2.createQuery("from Subject");
            subjectList = q.list();
            levelList = session2.createQuery("from Level").list();

        // Forwarding to the JSP
            return SUCCESS;
    }

    public List<Object> getLevelList() {
        return levelList;
    }
    public List<Object> getSubjectList() {
        return subjectList;
    }    
}