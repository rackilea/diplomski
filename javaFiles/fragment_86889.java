public class GetMyStuffResult implements ORAData, ORADataFactory {

    string first_name;
    string last_name;

    // Assume appropriate getters and setters for all properties here
    // public String getFirstName() {
    //      |
    //      |

    // Implement ORAData and ORADataFactory
    public ORAData create(Datum datum, int sqlType throws SQLException {
       GetMyStuffResult result = new GetMyStuffResult();

       Struct javaStruct = (Struct) datum;
       Object[] attributes = javaStruct.getAttributes();
       // ORDER MATTERS HERE - must be in order defined in Oracle
       result.setFirstName(attributes[0].toString());
       result.setLastName(attributes[1].toString());
    }

    public Datum toDatum(Connection conn) throws SQLException {
        return null;
    }
}