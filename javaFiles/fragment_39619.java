public class ReoprtSearch {
    public String[] executeTasks() {
        PropEnum props[] = new PropEnum[] { PropEnum.searchPath, PropEnum.defaultName};
        BaseClass bc[] = null;

        String searchPath = "//report";
    //searchPath for folder - //folder, report - //report, folder and report - //folder | //report 

        try {
            SearchPathMultipleObject spMulti = new SearchPathMultipleObject(searchPath);
            bc = cmService.query(spMulti, props, new Sort[] {}, new QueryOptions());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        if (bc != null) {
            String results[] = new String[bc.length];
            for (int i = 0; i < bc.length; i++) {
                results[i] = bc[i].getDefaultName().getValue();
            }
            return results;
        }
        return null;
    }
}