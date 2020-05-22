import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.****.****.****.ExcelListenerBean;
import com.****.****.****.RevAppViewBean;

public class RevPrdBrkDwnSP extends StoredProcedure{

    private final Logger log = Logger.getLogger(this.getClass().getName());

    private  Connection con = null;
    private DataSource ds = null;

    public RevPrdBrkDwnSP(DataSource dataSource, String storeProcName) throws SQLException {

        // Run the Parent
        super(dataSource, storeProcName);

        con = dataSource.getConnection();
        ds = dataSource;

        if (log.isInfoEnabled()) {
            log.info("Stored Procedure Name : "+ storeProcName);
        }
        // Declare the Parameter Details
        declareParameter(new SqlParameter("IN_ARRAY", OracleTypes.ARRAY, "****.PROD_PRCT_BRKDWN_TYPE_ARRAY"));
        declareParameter(new SqlOutParameter("OUT_ARRAY", OracleTypes.ARRAY, "****.PROD_PRCT_BRKDWN_TYPE_ARRAY"));

        // Compile the SP
        compile();
    }


    public List<ExcelListenerBean> execute(final RevAppViewBean appViewBean$Session, DataSource dataSource) throws Exception {
        dataSource = ds;
        List<ExcelListenerBean> beans = new ArrayList<ExcelListenerBean>();

        log.info("Setting up the Store Procedure Params");

        String getDBUSERByUserIdSql = "{call ****.PRCS_PROD_PRCT_BRKDWN_ENTRIES(?,?)}";
        CallableStatement cs = con.prepareCall(getDBUSERByUserIdSql);

        ArrayDescriptor des = ArrayDescriptor.createDescriptor("PBAREV.PROD_PRCT_BRKDWN_TYPE_ARRAY", con);
        ARRAY a = new ARRAY(des, con, appViewBean$Session.getExcelRecLst().toArray());
        cs.setObject(1, (Object)a);

        cs.registerOutParameter(2, OracleTypes.ARRAY, "****.PROD_PRCT_BRKDWN_TYPE_ARRAY");

        if (log.isDebugEnabled()) {
            log.debug("Executing the PBAREV Store Procedure ");
        }

        cs.execute();
        log.info("Executed ****.PRCS_PROD_PRCT_BRKDWN_ENTRIES... Processing values to beans"); 

        Array arr = cs.getArray(2);

        Object[] objArr = (Object[]) arr.getArray();
        for(int i=0; i<objArr.length;i++){
            STRUCT st = (STRUCT)objArr[i];
            ExcelListenerBean bean = new ExcelListenerBean();
            Object[] obj = st.getAttributes();
            bean.setPrntGdwIdN(((BigDecimal)obj[1]).longValue());
            bean.setChldGdwIdN(((BigDecimal)obj[2]).longValue());
            bean.setChldAsetPrcntN(Double.valueOf(String.valueOf(obj[4])));
            bean.setStatus(String.valueOf(obj[8]));
            bean.setStatusMessage(String.valueOf(obj[9]));
            beans.add(bean);
        }

        if (log.isDebugEnabled()) {
            log.info("Finised processing SP output values to ExcelListenerBeans");
        }

        return beans;
    }
}