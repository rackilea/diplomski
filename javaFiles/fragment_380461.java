try {
...
} catch(Exception e) {
  try {
      response.sendError(500);
    } catch(IOException e2) {
      e2.initCause(e);
      throw e2;
    }
}