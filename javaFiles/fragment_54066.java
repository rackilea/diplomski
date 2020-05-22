@RequestMapping(value = "/{app}/conf/{fnm}", method=RequestMethod.GET)
public ResponseEntity<?> getConf(@PathVariable("app") String app, @PathVariable("fnm") String fnm) {
   log.debug("AppName:" + app);
   log.debug("fName:" + fnm);
           ...
           return ...
  }