private void getFunctionReferences(BasicBlock block, HashSet<Integer> blockAddresses){ 
    for (int x : block.getAddressReferenceList()) {  
        if (blockAddresses.add(x)) { // only make a recursive call if x wasn't already
                                     // in the Set
            getFunctionReferences(this.blockList.get(x), blockAddresses);
        }
    }
}