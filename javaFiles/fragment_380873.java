boolean continueLooping = true;
do {
    try {
         ucdr = beanReader.read(ConvergeDataRow.class, headers, processors);
         if (ucdr != null) {
           rdata.add(ucdr);   // contains list of row data.
         }
         // this line will be skipped when an exception is thrown during 
         // parsing, but not if the line is successfully handled or on end of
         // file .
         continueLooping = ucdr != null;
     } catch (SuperCsvConstraintViolationException ex) {
          logger.log(Level.SEVERE, "NON CORRECT VALUE ENCOUNTERD ON ROW "+beanReader.getRowNumber(), ex);
          treatedOk = false;

     } catch (SuperCsvCellProcessorException ex){
         logger.log(Level.SEVERE, "PARSER EXCEPTION ON ROW "+beanReader.getRowNumber(), ex);
         treatedOk = false;
     } catch (org.supercsv.exception.SuperCsvException ex){
          logger.log(Level.SEVERE, "ERROR ON ROW "+beanReader.getRowNumber(), ex);
                    treatedOk = false;
     }

} while (continueLooping);
treatedOk = true;