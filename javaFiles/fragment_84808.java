public static class LocalDateModel implements IModel<java.util.Date> {
    private IModel<LocalDate> localDateModel;
    public LocalDateModel(IModel<LocalDate> localDateModel){
        this.localDateModel = localDateModel;
    }


    @Override
    public Date getObject() {
        return convertLocalDateToUtilDateSomehow(localDateModel.getObject());
    }

    @Override
    public void setObject(Date object) {
        localDateModel.setObject(convertUtilDateToLocalDateSomehow(object));
    }

    @Override
    public void detach() {
        localDateModel.detach();
    }
}