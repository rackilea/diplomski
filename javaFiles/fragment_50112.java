public class SecuritiesInfoManager extends Manager {

 @Autowired
    public void setSecuritiesInfoDAOInterface(SecuritiesInfoDAOInterface _securitiesInfoDAOInterface) {
        this._securitiesInfoDAOInterface = _securitiesInfoDAOInterface;
    }

public List<SecuritiesInfo> getAll() {
return _securitiesInfoDAOInterface.getAll();
 }
}