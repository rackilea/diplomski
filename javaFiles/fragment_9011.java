public class SensorDBConnection extends ... {
    public List<Sensor> loadData() {
        List<Sensor> sensors = new ArrayList<>(25);
        try {
            //...
            while(results.next())
            {
                time = results.getInt(1);
                id = results.getInt(2);
                temp = results.getInt(3);
                hum = results.getInt(4);
                light = results.getInt(5);
                voltage = results.getInt(6);
                model.addRow(new Object[]{time,id,temp,hum,light,voltage});
                Sensor sens = new Sensor(id, temp, hum, light, voltage);
                sensors.add(sens);               
            }
        } finally {
            try {
                results.close();
            } catch (Exception exp) {
            }
            try {
                stmt.close();  
            } catch (Exception exp) {
            }
        }
        return sensors;
    }
}