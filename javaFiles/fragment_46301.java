public static BaseDAO<?> getDAO(Class dtoClass) {

    String dtoClassName = dtoClass.getName();
    String daoClassName = dtoClassName.replaceAll("DTO$", "DAO");
    Class daoClass =  Class.forName(daoClassName);
    retrun daoClass.newInstance(daoClass);
}