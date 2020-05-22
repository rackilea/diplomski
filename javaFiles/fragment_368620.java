JGroupsAddress myAddress = (JGroupsAddress)getInstance().cacheManager.getCache(cacheName).getAdvancedCache().getRpcManager().getAddress();
List members =getInstance().cacheManager.getCache(cacheName).getAdvancedCache().getRpcManager().getTransport().getMembers();
            if(members != null && members.size() > 2) {
                for(JGroupsAddress member : (List<JGroupsAddress>)members) {
                    if(!member.getJGroupsAddress().equals(myAddress.getJGroupsAddress())) {
                        return true;
                    }
                }
            }