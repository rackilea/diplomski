jdbcTemplate = new JdbcTemplate(dataSource);
 jdbcTemplate.execute("INSERT INTO PHOTO (PHOTO_IM) VALUES (?)",
                      new AbstractLobCreatingPreparedStatementCallback(lobHandler) {                         
                              protected void setValues(PreparedStatement ps, LobCreator lobCreator) {                                                    
                              try {
                                 lobCreator.setBlobAsBinaryStream(ps, 1, bean.getImageOrig(), bean.getImageLength());                               
                                } catch (java.sql.SQLException e) {
                                    e.printStackTrace();
                                }     

                              }

                          }
                );