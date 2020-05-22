public static AllCountriesRow valueOf(BytesRefArrayWritable braw) throws IOException                                                     
{   
    try                                                                                                                                  
    {
        StructObjectInspector soi = (StructObjectInspector) serDe.getObjectInspector();                                                  
        Object row = serDe.deserialize(braw);                                                                                                                                                                                 
        List<? extends StructField> fieldRefs = soi.getAllStructFieldRefs();                                                                                                                                              

        Object fieldData = soi.getStructFieldData(row, fieldRefs.get(Column.ID.ordinal()));                                                                  
        ObjectInspector oi = fieldRefs.get(Column.ID.ordinal()).getFieldObjectInspector();                                               
        int id = ((IntObjectInspector)oi).get(fieldData);                                                                                

        fieldData = soi.getStructFieldData(row, fieldRefs.get(Column.NAME.ordinal()));                                                   
        oi = fieldRefs.get(Column.NAME.ordinal()).getFieldObjectInspector();                                                             
        String name = ((StringObjectInspector)oi).getPrimitiveJavaObject(fieldData);                                                     

        fieldData = soi.getStructFieldData(row, fieldRefs.get(Column.CODE.ordinal()));                                                   
        oi = fieldRefs.get(Column.CODE.ordinal()).getFieldObjectInspector();
        String code = ((StringObjectInspector)oi).getPrimitiveJavaObject(fieldData);                                                     

        fieldData = soi.getStructFieldData(row, fieldRefs.get(Column.REGION_NAME.ordinal()));                                            
        oi = fieldRefs.get(Column.REGION_NAME.ordinal()).getFieldObjectInspector();                                                      
        String regionName = ((StringObjectInspector)oi).getPrimitiveJavaObject(fieldData);                                               

        fieldData = soi.getStructFieldData(row, fieldRefs.get(Column.CONTINENT_ID.ordinal()));                                           
        oi = fieldRefs.get(Column.CONTINENT_ID.ordinal()).getFieldObjectInspector();                                                     
        int continentId = ((IntObjectInspector)oi).get(fieldData);                                                                       

        return new AllCountriesRow(id, name, code, regionName, continentId);                                                             
    }               
    catch (SerDeException e)
    {               
        throw new IOException(e);                                                                                                        
    }                   
}