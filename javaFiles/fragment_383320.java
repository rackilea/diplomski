public void loadCustomer(int id) {
    mCustomerModel.load(id);
    mCustomerView.setId(mCustomerModel.getId());
    mCustomerView.setFirstName(mCustomerModel.getFirstName());
    mCustomerView.setLastName(mCustomerModel.getLastName());

}