for(Properties prop: obj){
    if(prop instanceof SubProperty){
        SubProperty subProp = (SubProperty)prop;
        System.out.println(subProp);
    }
}