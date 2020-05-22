import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class StudentMapper extends Student implements SQLData {

    public StudentMapper(Student student) {
        setName(student.getName());
        setAddress(student.getAddress());
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return "MY_SCHEMA.STUDENT";
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        setName(stream.readString());
        setAddress((Address) stream.readObject());
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeString(getName());
        final AddressMapper addressMapper = new AddressMapper(getAddress());
        stream.writeObject(addressMapper);
    }
}

final StudentMapper mapper = new StudentMapper(studentInstance);
CallableStatement callableStatement = ...
callableStatement.setObject("studentObject", mapper);
callableStatement.execute();