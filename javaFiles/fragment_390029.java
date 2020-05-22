import java.sql.*;

public class Elem implements SQLData {

    private Integer elementId;

    public String getSQLTypeName() { return "ELEM"; }

    public void readSQL(SQLInput input, String typeName) throws SQLException {
        elementId = input.readInt();
    }

    public void writeSQL(SQLOutput output) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return "<Element " + elementId + ">";
    }
}