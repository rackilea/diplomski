DatabaseMetaData p_metadata= connection.getMetaData();
ResultSet v_resultPrimaryKey = p_metadata.getImportedKeys(null, Tools.getDBName(), "bookmarks_tags");

   if (v_resultPrimaryKey.next()) {
       System.out.println("test");
       v_resultPrimaryKey.beforeFirst();
       v_resultPrimaryKey.beforeFirst();

            while (v_resultPrimaryKey.next()) {
                if (p_att.equals(v_resultPrimaryKey.getString("FKCOLUMN_NAME"))) {
                    String v_fk = v_resultPrimaryKey.getString("PKTABLE_NAME") + "."
                           + v_resultPrimaryKey.getString("PKCOLUMN_NAME");
                    String v_fkName = v_resultPrimaryKey.getString("FK_NAME");
                }
            }               

            if(!v_fk.equals("")){
                v_foreignKey = new ForeignKey(v_fkName, v_fk);
            }


        }