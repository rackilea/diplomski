public class MyUI extends ... {
     private JTable table;
     private SensorDBConnection sensor;
     //...
     protected void loadTableContents() {
         TableModel model = null;
         try {
            model = new SensorTableModel(sensor.loadData());
         } catch (SQLException exp) {
             // Handle exception
         }
         table.setModel(model);
     }
 }