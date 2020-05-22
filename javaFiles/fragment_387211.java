Object target = null;
for(Object e : EnumSet.allOf(yourEnumClass)){
    if(e instanceof MyInterface && ((MyInterface)e).getId()==thisId){
        target = e;
        break;
    }
}
return target;