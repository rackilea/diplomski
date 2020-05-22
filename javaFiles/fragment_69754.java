public List<Map<String, Object>> valueList(String dataSource, Object[] params, String sql) throws DataAccessException {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Clob clob = null;

    try {
      con = dataSource.getConnection();
      ps = con.prepareStatement( "SELECT samplefield FROM sampletable WHERE SDE.ST_INTERSECTS(SHAPE, SDE.ST_GEOMETRY(?, ?)) = 1 AND SHAPE IS NOT NULL" ); // probably externalize this SQL string somewhere

      // Note that Oracle's two-arg ST_GEOMETRY function takes a CLOB and an INTEGER
      // see http://resources.arcgis.com/en/help/main/10.1/index.html#//006z00000050000000
      Clob clob = OracleUtils.createTemporaryCLOB(conn, true, 10);                    
      clob.setString(1, (String) params[0]);
      ps.setClob( 1, clob );

      ps.setObject( 2, params[1], java.sql.Types.INTEGER );

      rs = ps.executeQuery();

      // inefficient and overdone output format, but hey.
      List<Map<String,Object>> out = new LinkedList()
      while (rs.next()) {
         Map<String,Object> oneBindingMap = new HashMap(1);
         oneBindingMap.put("samplefield", rs.getObject(1)); //again, maybe externalize the field name
         out.add( oneBindingMap );
      }
      return out;
    }
    catch ( SQLException e ) {
     throw new DataAccessException( e.getMessage(), e ); // adapt to expected Exception type
    }
    finally {
      try { if ( clob != null ) clob.free(); } catch ( Exception e ) { e.printStackTrace(); }

      // in java 7+ you could avoid the rest of this via the try-with-resources construct
      try { if ( rs != null ) rs.close(); } catch ( Exception e ) { e.printStackTrace(); }
      try { if ( ps != null ) ps.close(); } catch ( Exception e ) { e.printStackTrace(); }
      try { if ( con != null ) con.close(); } catch ( Exception e ) { e.printStackTrace(); }
    }
}