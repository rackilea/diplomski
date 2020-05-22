public class Park {

    public Connection con = null;

    public void parkMethod() {
        SQLConnections sqlConnections = new SQLConnections();
        sqlConnections.parkInSQL();

        int countCar = sqlConnections.countCar;
        int countMotor = sqlConnections.countMotor;
        int countVan = sqlConnections.countVan;
    }

}