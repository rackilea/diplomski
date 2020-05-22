public List<String> load() {
        List<String> pcChoices = new ArrayList<String>();
        for(ProductCategory pc : categoryService.findAllProducts()) {
            pcChoices.add(pc.getName());
        }
        return pcChoices;
    }