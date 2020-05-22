/*Code to support Weblogic datatypes*/
  Object returnObj = stmt.getObject(2);
  if (returnObj instanceof Struct)
                output_oracle_record = (oracle.sql.STRUCT)(((weblogic.jdbc.wrapper.Struct)returnObj).unwrap(Class.forName("oracle.sql.STRUCT")));
            else
                output_oracle_record = (oracle.sql.STRUCT)returnObj;

            /*code for tomcat deployment*/
            //output_oracle_record = ((OracleCallableStatement)stmt).getSTRUCT(2);