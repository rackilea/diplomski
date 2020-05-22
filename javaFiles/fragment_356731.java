@RequestMapping(method = RequestMethod.POST)
public ret_type updateUser(param) {
    updateSharedStateByCommunityBlocks(resolveIds);
}

...

And in Service introduce a new method (if you can't change the code of the service provide an intermediate class that you'll call from controller with the following functionality):

@Transactional
public updateSharedStatedByCommunityBlocks(resolveIds) {
    List<String> [] blocks = split(resolveIds, 100000);  // 100000 - bulk size
    for(List<String> block :blocks) {
       updateSharedStateByCommunity(block); 
    }
}