while (rs.next()) {
                    ObjectsEntity oe = new ObjectsEntity();
                    oe.setOBJECTID(rs.getInt("OBJECTID"));
                    Plants plants = new Plants();
                    plants.setId(rs.getInt("PLANTID"));
                      //Set other fields.
                    oe.setPLANTS(plants);
                    oe.setOBJECTNAME(rs.getString("OBJECTNAME"));
                    oe.setOBJECTTYPEID(rs.getInt("OBJECTTYPEID"));
                    oe.setDESCRIPTION(rs.getString("DESCRIPTION"));
                    oe.setISMONITORED(rs.getBoolean("ISMONITORED"));
                    oe.setGROUP(rs.getString("GROUP"));
                    list.add(oe);
                }