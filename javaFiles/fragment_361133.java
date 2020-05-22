public Host getHost (String domain) {
        for(int i = 0; i < hosts.size(); i++) {
            if(domain.equals(hosts.get(i).getDomain())) {
              return hosts.get(i);
            }
        }      
        return null;
    }