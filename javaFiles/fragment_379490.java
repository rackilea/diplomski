public class Application {

    List<Alert> alerts;
    restConnector connect;

    public Application() {
        initComponents();
    }

    private void initComponents() {
        connector = restConnector.getInstance();
        connector.init();
        alerts = connector.getAlerts();
        refreshData();          
    }   

    private void refreshData() {
        StringBuilder sb = new StringBuilder();
        for (Alert alert : alerts) {
            sb.append(alert.toString()).append("\n");
        }
        System.out.println("appalertList: "+ sb.toString());
    }     
}