public void processRequest(name, age, sex, country)
{
    UserRegister ureg=new UserRegister(name,age,sex,country);
    ureg.updateSomeFields();
    ureg.doSomeBusinessLogic();
    ureg.prepareDBData();
    ureg.storeInDb();
}