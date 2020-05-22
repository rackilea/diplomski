@RequestMapping(value = "/env", method = RequestMethod.POST)
public String env(@ModelAttribute("envBean") EnvBean envBean){

    logger.info("parameter is " + envBean.getEnv());
    return "index";

}