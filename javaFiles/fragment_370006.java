public void searchBranch (StringTreeNode tmp, String value) {    
    if(value.equals(tmp.data)) {
        System.out.println("Records found, " + value + " exist in search history!");
        found = true;
    } else if (value.compareTo(tmp.data) < 0)
        searchBranch(tmp.left, value);
    else 
        searchBranch(tmp.right, value);
}