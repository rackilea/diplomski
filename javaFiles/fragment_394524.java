if(resultSet.getInt(columnNumber) != null){
    if(resultSet.getInt(columnNumber) != 0){
        System.out.println("int is not zero");
    } else {
        System.out.println("int is zero");
    }
}else{
    System.out.println("int is null");
}