public enum IMType implements CodeableEnum {
    ...
    public IMType getByCode(String code) {
        return (IMType)CodeableEnumHelper.getByCode(code, this.values());
    } 
}