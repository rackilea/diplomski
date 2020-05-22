@Override
                          public int compare( JsonElement o1,
                                  JsonElement o2 )
                          {

                              if( Integer.parseInt( o1.getAsJsonObject()
                                      .get( "com.tangoe.matrix.catalog.CatalogFeatureDetail" )
                                      .getAsJsonObject()
                                      .get( "order" )
                                      .toString()
                                      .replace( "\"",
                                                "" ) ) > Integer.parseInt( o2.getAsJsonObject()
                                      .get( "com.tangoe.matrix.catalog.CatalogFeatureDetail" )
                                      .getAsJsonObject()
                                      .get( "order" )
                                      .toString()
                                      .replace( "\"",
                                                "" ) ) )
                              {
                                  return 1;
                              }
                              else if( Integer.parseInt( o1.getAsJsonObject()
                                      .get( "com.tangoe.matrix.catalog.CatalogFeatureDetail" )
                                      .getAsJsonObject()
                                      .get( "order" )
                                      .toString()
                                      .replace( "\"",
                                                "" ) ) < Integer.parseInt( o2.getAsJsonObject()
                                      .get( "com.tangoe.matrix.catalog.CatalogFeatureDetail" )
                                      .getAsJsonObject()
                                      .get( "order" )
                                      .toString()
                                      .replace( "\"",
                                                "" ) ) )
                              {
                                  return -1;
                              }
                              else
                              {
                                  return 0;
                              }

                          }
                      } );

    return list;

}