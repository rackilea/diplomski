public class UsrMapper extends RowMapper<Usr> {

    @Override
    public State mapRow(ResultSet rs, int rowNum) throws SQLException {

        Usr usr = new Usr();
        Vehicle vehicle = new Vehicle();

        usr.setId(rs.getInt("usr.id"));
        vehicle.setId(rs.getInt("vehicle.id"));
        vehicle.setYear(rs.getInt("vehicle.year"));
        vehicle.setModel(rs.getString("vehicle.model"));

        usr.setVehicle(vehicle);

        return usr;
    }
}