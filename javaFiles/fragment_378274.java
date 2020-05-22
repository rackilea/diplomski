@Override
public MboSetRemote getList() throws MXException, RemoteException {
    MboSetRemote result = super.getList();

    //Here is where i want to use the value
    String string = "....:fieldName...";
    result.setWhere(string);

    return result;
}