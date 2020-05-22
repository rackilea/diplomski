List<Produc> resultList = new ArrayList<>();
    List<Object[]> listObj = (List<Object[]>)query.getResultList();
    for(Object[] obj: listObj){
        String name = String.valueOf(obj[0]);
        String price = String.valueOf(obj[1]);
        resultList.add(new Product(name, price);
    }
    return resultList;
}