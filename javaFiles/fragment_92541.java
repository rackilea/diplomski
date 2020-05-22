public class AS400Statusfacade {
    Logger logger=Logger.getLogger(AS400Statusfacade.class);
    @Autowired
    AS400StatusDAO aS400StatusDAO=null;

    public String getAS400StatusInformation() {
        return aS400StatusDAO.getAS400Status();
    }
}