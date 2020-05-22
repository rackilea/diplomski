DataModel<MyInfo> myInfoModel; // +getter

@PostConstruct
public void init() {
    myInfo = myInfoDAO.list();
    myInfoModel = new ListDataModel<MyInfo>(myInfo);
}