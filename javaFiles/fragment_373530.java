[Task() Constructor]
Properties props = new Properties();
URL url = ClassLoader.getSystemResource("log4j.properties");
try {
    props.load(url.openStream());
    PropertyConfigurator.configure(props);
} catch (Exception e) {
    //The logger that never got renamed never stopped working.
    Logger.getLogger(TaskPoller.class).error("Diagnostics!");
}
logger = Logger.getLogger(Task.class);