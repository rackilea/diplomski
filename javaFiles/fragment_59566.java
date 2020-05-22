addCriteria(Criteria criteria, String name, String value){

 //you wanna handle special cases like null == name as well accordingly

    if (null != value && !value.isEmpty() && null != name && !name.isEmpty()){
        criteria.add(Expression.eq(name, value)) ;
    }
}