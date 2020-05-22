@Override
public List<ApplicationDTO> getAllApplication() {

    List<ApplicationDTO> AppList = genericDAOTxService.findAll(ApplicationDTO.class);   
    return AppList;     
}