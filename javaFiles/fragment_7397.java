@Required
public void setDao(PersonDao dao) {
    if (dao == null)
        throw new IllegalArgumentException("property 'dao' is null");
    this.dao = dao;
}