//!!! The try is catching the exception for you. Remove it to see the real problem.
 try {
        URIBuilder builder = new URIBuilder("http://api.fantasydata.net/soccer/v2/json/Schedule/73");
        ...
        for (int x = 0; x <= fixtures.length; x++) {
            // Exception somewhere
        }
    }
  catch(Exception e) {

  }