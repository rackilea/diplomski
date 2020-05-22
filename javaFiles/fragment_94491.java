@GetMapping(value = "/showheaders")
public String getHeaders(@ModelAttribute MyHeaderHolder myHeaderHolder) {
    logger.info("Inside getHeaders() method...");
    logger.info("sample : " + myHeaderHolder.getSample());
    logger.info("sample1 : " + myHeaderHolder.getSample1());
    logger.info("sample2 : " + myHeaderHolder.getSample2());
    logger.info("sample3 : " + myHeaderHolder.getSample3());
    logger.info("sample4 : " + myHeaderHolder.getSample4());    
}