private FlexibleSearchService flexibleSearchService;

    @Override
    public void onValidate(PurchaseAmountTimeSliceModel paramMODEL, InterceptorContext paramInterceptorContext)
        throws InterceptorException {

       //.....
       final StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("select {ts.pk}");
        queryBuilder.append(
                " from {Order as or join CustomerOrderStatus as os on {or:CustomerOrderStatus}={os:pk} join OrderEntry as oe on {or.pk}={oe.order} ");
        queryBuilder.append(
                "join PurchaseAmount as pa on {or.pointOfSale}={pa.purchaseAmountOwner} join PurchaseAmountTimeSlice as ts on {pa.pk}={ts.purchaseamount}} where ");

        if (pointOfSale != null && company != null) {
            queryBuilder.append("{or:company} in (" + company.getPk() + ") and {or:pointOfSale} in ("
                    + pointOfSale.getPk() + ")");
        }
        FlexibleSearchQuery query = new FlexibleSearchQuery(queryBuilder.toString());
        SearchResult<PurchaseAmountTimeSliceModel> result = flexibleSearchService.search(query);

        if (result != null) {
            if (result.getCount() >= 10) {
                LOG.error("There's already 10 purchase amount time slices configured. You reached the limit.");
                throw new InterceptorException(
                        "There's already 10 purchase amount time slices configured. You reached the limit.");
            }
        }
    //.....