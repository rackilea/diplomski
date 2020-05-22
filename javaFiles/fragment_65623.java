Commandline cl = new Commandline();
cl.setExecutable( COMMAND_CLASS );
cl.createArg().setValue( TASK_CLASS );

CommandLineBuilder builder = new CommandLineBuilder( "macker" );
for ( Iterator/*<String>*/it = options.iterator(); it.hasNext(); ) {
   builder.addArg( (String) it.next() );
}
builder.saveArgs();
String commandsFile =  builder.getCommandLineFile();
cl.createArg().setValue( commandsFile );

StringStreamConsumer stdout = new StringStreamConsumer();
StringStreamConsumer stderr = new StringStreamConsumer();
int exitCode = CommandLineUtils.executeCommandLine( cl, stdout, stderr );