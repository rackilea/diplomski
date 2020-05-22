List possibleValues = ... 
StringBuilder builder = new StringBuilder();

for( int i = 0 ; i < possibleValue.size(); i++ ) {
    builder.append("?,");
}

String stmt = "select * from test where field in (" 
               + builder.deleteCharAt( builder.length() -1 ).toString() + ")";
PreparedStatement pstmt = ...