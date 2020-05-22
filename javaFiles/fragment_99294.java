private String myCSVValues;
...
public List<MyEnum> getMyEnums() {
    String[] csvs = this.myCSVValues.split(",");
    List<MyEnum> myEnums = new ArrayList<MyEnum>();
    for (String s : csvs) {
        myEnums.add(MyEnum.valueOf(s));
    }
    return myEnums;
}

public void setMyEnums(List<MyEnum> myEnums) {
    this.myCSVValues = org.apache.commons.lang3.StringUtils.join(myEnums, ",");
}