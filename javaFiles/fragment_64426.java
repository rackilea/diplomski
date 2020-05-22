public static int run(Configuration conf, Tool tool, String[] args) 
throws Exception{
if(conf == null) {
  conf = new Configuration();
}
GenericOptionsParser parser = new GenericOptionsParser(conf, args);
//set the configuration back, so that Tool can configure itself
tool.setConf(conf);

//get the args w/o generic hadoop args
String[] toolArgs = parser.getRemainingArgs();
return tool.run(toolArgs);