class MyHtmlMapper extends DefaultHtmlMapper {

    public public boolean isDiscardElement(String name) {
        //put here not wanted attributes
        HashSet<String> discardAttrs = new HashSet<String>();

        if (discardAttrs.contains(name) && eleName.equals("div")) {
            return true;
        } 
        return false;  
    }
)