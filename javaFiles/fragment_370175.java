public class YourAction {

    private List<Object> levelList; // private
    private List<Object> subjectList; // private

    public String execute() throws Exception {      
        // Call the service, load data
        levelList = getMyService().getLevelList();
        subjectList = getMyService().getSubjectList();

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