class ProductCategoryMap
{
    Map<String,Set<String>> prodMap;
    Map<String,String> codeMap;
    Map<String,Integer> catMap;

    public ProductCategoryMap()
    {
        prodMap = new HashMap<>();
        codeMap = new HashMap<>();
        catMap = new HashMap<>();
    }

    public void put(String category, String region, int code)
    {
        if(!prodMap.containsKey(category))
        {
            prodMap.put(category, new TreeSet<>());
        }
        prodMap.get(category).add(region);

        catMap.put(category+region, code);
        codeMap.put(region+code, category);
    }

    public String getCategory(String country, int catId)
    {
        return codeMap.get(country+catId);
    }

    public int getCategoryId(String category, String country)
    {
        return catMap.get(category+country);
    }

    public int getDestCatId(String srcCountry, String destCountry, int srcCatId)
    {
        String category = getCategory(srcCountry, srcCatId);
        return getCategoryId(category, destCountry);
    }

    public TreeSet<String> getAvailability(String category)
    {
        return prodMap.get(category);
    }
}