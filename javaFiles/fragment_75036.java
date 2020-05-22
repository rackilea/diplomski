PService phsService = new PService(url, SERVICE_NAME);
      P p = phsService.getPHSPort();
      LOG.info("Calling Web Service : getHs");

      StringArray ar = p.getHs();

      for (String hn: ar.getItem()) {
         LOG.info("Calling : getHName : " + hn);
         Dto nDto = p. getHName (hn);

         // process the result   

      }