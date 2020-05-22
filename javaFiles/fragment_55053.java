@InitBinder
protected void initBinder(WebDataBinder binder) throws Exception {
    logger.debug("in binding for service categories");
    binder.registerCustomEditor(List.class, "serviceCategories",
            new CustomCollectionEditor(List.class) {
                @Override
                protected Object convertElement(Object element) {
                    String serviceCategoryId = (String) element;
                    logger.info("service category id = " + serviceCategoryId);
                    List<ServiceCategory> serviceCategoryList = null ;
                    if (serviceCategoryId != null) {
                        logger.info("found object");
                        Map<String, Object> whereClauses = new HashMap<>();
                        whereClauses.put(Constants.ID, serviceCategoryId);

                        try {
                            serviceCategoryList = serviceCategoryService.findServiceCategories
                                        (whereClauses, null , null, Constants.ACTIVE);
                        } catch (Exception e) {
                            logger.error(e.getMessage(), e);                                
                        }                       
                    }
                    return serviceCategoryList;
                }
            });

}