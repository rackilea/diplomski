@Formula(value = "(select fnHasProducts(customerId) from dual)")
    @AccessType("property")
    private Integer products = 0;

@Formula(value = "(select fnAssigneeForProduct(productId) from dual)")
    private Integer assignee = 0;