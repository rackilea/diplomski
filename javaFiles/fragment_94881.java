private Configuration()  {
    try {
        ini= new Wini(new File(Constants.PATH));
    }
    catch (Exception e) {
        LOGGER.error("Exception during init of Configuration",e);
    }
}