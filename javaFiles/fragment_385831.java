@InitBinder
    protected void initBinder(WebDataBinder binder) 
    {
        binder.registerCustomEditor(List.class, "servicesList", new CustomCollectionEditor(List.class)
        {
            @Override
            protected Object convertElement(Object element)
            {
                Integer id = null;

                if(element instanceof String && !((String)element).equals("")){
                    try{
                        id = Integer.parseInt((String) element);
                    }
                    catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                else if(element instanceof Integer) {
                    id = (Integer) element;
                }

                return id != null ? marketServiceService.getMarketServiceById(id) : null;
            }
        });
    }