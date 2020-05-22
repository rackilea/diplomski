@RequestMapping(value = "data", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON) // import javax.ws.rs.core.MediaType
public @ResponseBody JSONArray getData() {

    List<LogEntry> logs = logEntryManager.getLogsByDate( new Date() );

    JsonConfig config = new JsonConfig();
    config.addIgnoreFieldAnnotation(com.fasterxml.jackson.annotation.JsonIgnore.class);

    Log.trace("Get LogEntry Data Only");
    JSONArray jsonArray = JSONArray.fromObject( logs, config );

    return jsonArray;
}