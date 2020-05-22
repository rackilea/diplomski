public void setTypeMap(Map<String,Actions> typeMap){
    this.typeMap = typeMap;
}

@Override
public OrganizationActions getDaoObject() {
    return typeMap.get(dbType);
}