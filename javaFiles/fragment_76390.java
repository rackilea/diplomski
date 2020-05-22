import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;
import oracle.jpub.runtime.MutableStruct;
import oracle.sql.BLOB;
import oracle.sql.Datum;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.STRUCT;

public class OracleAQObjORADataFactory  implements ORAData, ORADataFactory {

    public static final String EVENT_OBJECT = "SYSTEM.AQ_EVENT_OBJ";
    public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

    protected MutableStruct _struct;

    protected static int[] _sqlType = { java.sql.Types.VARCHAR, java.sql.Types.VARBINARY };
    protected static ORADataFactory[] _factory = new ORADataFactory[2];
    protected static final OracleAQObjORADataFactory  _AqEventObjFactory = new OracleAQObjORADataFactory ();

    public static ORADataFactory getORADataFactory() {
        return _AqEventObjFactory;
    }

    /* constructors */
    protected void _init_struct(boolean init) {
        if (init)
            _struct = new MutableStruct(new Object[2], _sqlType, _factory);
    }

    public OracleAQObjORADataFactory () {
        _init_struct(true);
    }

    public OracleAQObjORADataFactory (String id, byte[] payload) throws SQLException {
        _init_struct(true);
        setId(id);
        setPayload(payload);
    }

    /* ORAData interface */
    public Datum toDatum(Connection c) throws SQLException {
        return _struct.toDatum(c, EVENT_OBJECT);
    }

    /* ORADataFactory interface */
    public ORAData create(Datum d, int sqlType) throws SQLException {
        return create(null, d, sqlType);
    }

    protected ORAData create(OracleAQObjORADataFactory  o, Datum d, int sqlType) throws SQLException {
        if (d == null)
            return null;
        if (o == null)
            o = new OracleAQObjORADataFactory ();
        o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
        return o;
    }

    public String getId() throws SQLException {
        return (String) _struct.getAttribute(0);
    }

    public void setId(String id) throws SQLException {
        _struct.setAttribute(0, id);
    }

    public byte[] getPayload() throws SQLException {
        BLOB blob = (BLOB) _struct.getAttribute(1);
        InputStream inputStream = blob.getBinaryStream();
        return getBytes(inputStream);
    }

    public byte[] getBytes(InputStream body) {
        int c;
        try {
            ByteArrayOutputStream f = new ByteArrayOutputStream();
            while ((c = body.read()) > -1) {
                f.write(c);
            }
            f.close();
            byte[] result = f.toByteArray();
            return result;
        }
        catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void setPayload(byte[] payload) throws SQLException {
        _struct.setAttribute(1, payload);
    }

}