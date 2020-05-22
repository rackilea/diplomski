PropertyColumn column = new PropertyColumn( columnId,new Model<String>( columnName ),
                                          somePropertyExpression,
                                          sortProperty ) {

       @SuppressWarnings("rawtypes")
       @Override
       public String getCellCssClass( IModel rowModel,
                                      int rowNum ) {

          if( getId().equals( "testid" ) ) {
                return "testCell";
          } else if( getId().equals( "blablaId" ) ) {
                return "blablaCell";
          } else {
                return null;
          }
      }
};