while (result.next()) {    
      Row row = new Row();
      row.internalCode = (((result_data = result.getObject("internal_code"))==null || result.wasNull())?" ":result_data.toString());
      row.externalRepresentation = (((result_data = result.getObject("external_representation"))==null || result.wasNull())?" ":result_data.toString());
      row.sorter = (((result_data = result.getObject("sorter"))==null || result.wasNull())?" ":result_data.toString());
      row.sDate = (((result_data = result.getObject("sDate"))==null || result.wasNull())?" ":result_data.toString());      
}