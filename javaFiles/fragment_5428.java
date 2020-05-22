while(resultSet has more results){
    move cursor to next row
    VCData row = //calls your mapRow method, passing in the current row #
    add row to List
}
return List<VCData>
close resultSet and cleanup