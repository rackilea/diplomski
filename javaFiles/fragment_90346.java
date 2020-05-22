// this is horrible, it ties the service layer to implementation
// details of the dao layer
private HibernateCustomerDaoImpl customerDao;
public void setCustomerDao(HibernateCustomerDaoImpl customerDao){
    this.customerDao = customerDao;
}