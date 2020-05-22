public List<ProductDTO> buyList() {
    List<Product> myProducts = productDAO.buyList();
    //convert the myProduct list to a list of ProductDTO
    //calculate the priceDifference
    //return the list od DTOs
    return dtoList;
}