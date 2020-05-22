CREATE OR REPLACE JAVA SOURCE NAMED "ServiceParamsBLOBHandler" AS
import java.io.*;
import java.util.*;
public class ServiceParamsBLOBHandler {

    private static Object deserialize(InputStream stream) throws Exception {

        ObjectInputStream ois = new ObjectInputStream(stream);
        try {
            return ois.readObject();
        } finally {
            ois.close();
        }
    }

    private static byte[] serialize(Object object) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(object);
        oos.close();
        return baos.toByteArray();
    }

    //@SuppressWarnings("unchecked")
    private static List<Map<String, String>> getParams(oracle.sql.BLOB blob) throws Exception {
        return (List<Map<String, String>>) deserialize(blob.getBinaryStream());
    }

    public static oracle.sql.BLOB updatedParamField(oracle.sql.BLOB blob, String paramName, String fieldName, String value)
            throws Exception {

        List<Map<String, String>> params = getParams(blob);
        Map<String, String> param = getParam(params, paramName);
        param.put(fieldName, value);
        oracle.sql.BLOB res = oracle.sql.BLOB.createTemporary(blob.getOracleConnection(), true, oracle.sql.BLOB.DURATION_CALL);
        res.setBytes(1, serialize(params));
        return res;
    }

    public static void updateParamField(oracle.sql.BLOB[] blobs, String paramName, String fieldName, String value)
            throws Exception {

        oracle.sql.BLOB blob = blobs[0];
        List<Map<String, String>> params = getParams(blob);
        Map<String, String> param = getParam(params, paramName);
        param.put(fieldName, value);
        blob.truncate(0);
        blob.setBytes(1, serialize(params));
    }

    private static Map<String, String> getParam(List<Map<String, String>> params, String name) {
        for (Map<String, String> param : params) {
            if (name.equals(param.get("name"))) {
                return param;
            }
        }
        return null;
    }

    public static String getParamField(oracle.sql.BLOB blob, String paramName, String fieldName) throws Exception {
        Map<String, String> param = getParam(getParams(blob), paramName);
        return param == null ? null : param.get(fieldName);
    }

}
/

alter java source "ServiceParamsBLOBHandler" compile
--select * from SYS.USER_ERRORS
/

CREATE OR REPLACE function getServiceParamField(b IN BLOB, paramName IN VARCHAR2, fieldName IN VARCHAR2) RETURN VARCHAR2
as LANGUAGE JAVA NAME 'ServiceParamsBLOBHandler.getParamField(oracle.sql.BLOB, java.lang.String, java.lang.String) return String';
/

CREATE OR REPLACE function updatedServiceParamField(b IN BLOB, paramName IN VARCHAR2, fieldName IN VARCHAR2, value IN VARCHAR2) RETURN BLOB
as LANGUAGE JAVA NAME 'ServiceParamsBLOBHandler.updatedParamField(oracle.sql.BLOB, java.lang.String, java.lang.String, java.lang.String) return oracle.sql.BLOB';
/

CREATE OR REPLACE PROCEDURE updateServiceParamField(b IN OUT BLOB, paramName IN VARCHAR2, fieldName IN VARCHAR2, value IN VARCHAR2)
AS LANGUAGE JAVA NAME 'ServiceParamsBLOBHandler.updateParamField(oracle.sql.BLOB[], java.lang.String, java.lang.String, java.lang.String)';
/

-- oracle blob read usage example:
select getServiceParamField(byte_value, 'account', 'format') from entity_property where name='params';

-- oracle blob update with java stored function usage example:
update entity_property set byte_value=updatedServiceParamField(byte_value, 'account', 'format', '15')
where name='params' and entity_id = 123

-- oracle blob update with java stored procedure usage example:
BEGIN
   FOR c IN (select byte_value from entity_property where name='params' and entity_id = 123 for update) LOOP
       updateServiceParamField(c.byte_value, 'account', 'format', '13');
   END LOOP;
END;
/