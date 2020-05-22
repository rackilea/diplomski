public class YourAction implements Preparable {

    private List<Object> levelList; // private
    private List<Object> subjectList; // private

    public void prepare() throws Exception {
        // Call the service, load data, 
        // every time even if validation fails
        levelList = getMyService().getLevelList();
        subjectList = getMyService().getSubjectList();
    }

    public String execute() throws Exception {      

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