catch (IOException ex) {
   DBGlobals.Error("OHMjson.Graph.saveLastGraphName - Error: " + ex.getMessage());
   msg = "Unable to save data";
   status = false;
   DBGlobalsException dbe = new DBGlobalsException(msg,ex);
   dbe.setField(status /* or whatever */);
   throw dbe;
}