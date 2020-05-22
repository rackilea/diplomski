/**
 * Class to provide access to the database. With this class you can invoke functions and stored procedures.
 */
public class GenericDatabaseCaller {

  /**Data source. */
  private DataSource dataSource;

  /**
   * This method requires LinkedHashMaps for inParams and outParams so that parameters can be set in a
   * sequence.
   * @param functionName Name of the stored procedure or function.
   * @param isFunction indicates if the process to execute is a Function or a Stored procedure.
   * @param inParams {@link LinkedHashMap} of IN parameters.
   * @param outParams {@link LinkedHashMap} of OUT Parameters.
   * @return {@link Map} with the output parameters.
   */
  public Map executeSimpleProcedure(String functionName, boolean isFunction, Map<String, Object> inParams,
      Map<String, Object> outParams) {
    InnerStoredProcedure innerStoredProcedure = new InnerStoredProcedure(dataSource, functionName, isFunction,
        inParams, outParams);
    return innerStoredProcedure.executeProcedure(inParams);
  }

  private class InnerStoredProcedure extends StoredProcedure {

    /**
     * @param ds
     * @param SQL
     * @param isFunction
     * @param inParams
     * @param outParams
     */
    public InnerStoredProcedure(DataSource ds, String SQL, boolean isFunction,  Map<String, Object> inParams, Map<String, Object> outParams) {
      setDataSource(ds);
      setFunction(isFunction);
      setSql(SQL);
      configerParameters(inParams, outParams);
      compile();
    }

    /**
     * Configure the input and output parameters for the stored procedure
     * @param inParams
     * @param outputParamers
     */
    public void configerParameters(Map<String, Object> inParams, Map<String, Object> outputParamers) {
      if (inParams != null && inParams.size() > 0) {
        Iterator<String> keySetIterator = inParams.keySet().iterator();
        while (keySetIterator.hasNext()) {
          String key = keySetIterator.next();
          if (inParams.get(key) instanceof String) {
            declareParameter(new SqlParameter(key, Types.VARCHAR));
          } else if (inParams.get(key) instanceof Integer) {
            declareParameter(new SqlParameter(key, Types.INTEGER));
          } else if (inParams.get(key) instanceof Date || inParams.get(key) instanceof java.sql.Date) {
            declareParameter(new SqlParameter(key, Types.DATE));
          }
          // TODO Add more types.
        }
      }

      if (outputParamers != null && outputParamers.size() > 0) {
        Iterator<String> keySetIterator = outputParamers.keySet().iterator();
        while (keySetIterator.hasNext()) {
          String key = keySetIterator.next();
          if (outputParamers.get(key) instanceof String) {
            declareParameter(new SqlOutParameter(key, Types.VARCHAR));
          } else if (outputParamers.get(key) instanceof Integer) {
            declareParameter(new SqlOutParameter(key, Types.INTEGER));
          }
        }
      }
    }

    public Map executeProcedure(Map inputs) {

      return execute(inputs);
    }
  }
}