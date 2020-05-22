public class DashboardController {
    private List<Dashboard> lstDashboard;
    public DashboardController() {
        try {
            lstDashboard = getDashboardList();
        } catch (Exception e) {
            //log the exception or something else...
        }
    }
    //getter and setter...
    public List<Dashboard> getLstDashboard() {
        return this.lstDashboard;
    }
    public void setLstDashboard(List<Dashboard> lstDashboard) {
        this.lstDashboard = lstDashboard;
    }
    //your other methods here...
}