final static Logger logger = LoggerFactory.getLogger(MyClass.class);

try{
    ..
}
catch(NumberFormatException e){
    logger.error("issue in ...", e);
}