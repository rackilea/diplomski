ImageItem.withTransaction {status ->
   try {
      imageItem.delete(flush: true)
   } catch (Exception e) {
      status.setRollbackOnly()   
      return 
   }

   Path outFile = Paths.get(fileUrl)
   try{
      if (Files.deleteIfExists(outFile)) {
        log.debug "delete() - file deleted: ${fileUrl}"
      } catch (e) {
         status.setRollbackOnly()
      }
}