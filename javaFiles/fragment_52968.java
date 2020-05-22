Map<String,IConvert> converts =  new HashMap<String, IConvert>(){
    put("varchar",new StringConver());
    put("date",new DateConver());
}
//then
converts.get(type).toParam(string)