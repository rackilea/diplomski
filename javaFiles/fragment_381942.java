import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public synchronized JSONObject getCustomerReferences(int custID) {

            DBTransaction trans=null;
            TransactionPool transactionPool = null;
            JSONArray myArrayOfRefs= new JSONArray();
            JSONObject myObject = new JSONObject();


        try {
            transactionPool = TransactionPool.get();
            trans = transactionPool.beginWork();

            Map<String, Object> optionalParams = new HashMap<String, Object>();
            optionalParams.put("customerId", custID);


             String selectQuery ="SELECT orderId AS ref FROM table1 WHERE custId='[customerId]';" //with 'AS' you can customize your output to any JSON name
             JSONArray myArrayOfRefs = null;
             ResultSet rs = mySQLTransactionHandle.query(selectQuery, optionalParams);
             if(rs.next()) {
                 myArrayOfRefs =  SQL2JSON.convert(rs);
                 }

             //add JSON array to a JSON object 
             myObject.put("rel_act", myArrayOfRefs); //Add null check.

        } catch (Exception e) {
            e.printStackTrace(); //Add logging
       }
        finally
        {
             try {
                    transactionPool.commit(mySQLTransactionHandle);
                } catch (SQLException e1) {
                    e1.printStackTrace(); //Add logging
                }
        }
            return myObject;
        }