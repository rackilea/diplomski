FirstClass {

String getStr();
void setSrt (String str);

@JsonDeserialize(
            as = ArrayList.class,
            contentAs = SecondClass.class
    )
List<SecondClass> getParams();
void setParams(List<SecondClass> params);

}