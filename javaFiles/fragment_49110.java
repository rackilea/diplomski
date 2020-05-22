List<AssetAllocationTO> someList = new ArrayList<AssetAllocationTO>();

for (String string : group.getAccounts().keySet()){
            AssetAllocationTO al = new AssetAllocationTO();
            al.setAccountID(string);
            someList.add(al);
}