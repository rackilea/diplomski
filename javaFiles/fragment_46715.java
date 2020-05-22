public Collection<Mutation> augment(ByteBuffer key, ColumnFamily update)
{
    CFMetaData cfm = update.metadata();
    String localKey = cfm.getKeyValidator().getString(key);
    logger.info("key={}.", localKey);

    for (Cell cell : update) 
    {
       try 
       {
           String name = cfm.comparator.getString(cell.name());
           logger.info("name={}.", name);

           String value = cfm.getValueValidator(cell.name()).getString(cell.value());
           logger.info("value={}.", value);               
       } catch (Exception e) {
           logger.info("Exception={}.", e.getMessage());
       }
   }
   return Collections.emptyList();