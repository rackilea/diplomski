for (Service s : os.getToken().getCatalog()) {
            if (s.getName().equals("swift")) {
                for (Endpoint e : s.getEndpoints()) {
                    if (e.getRegion().equals("dallas") && e.getIface().equals(Facing.PUBLIC)) {
                        objectUrl = e.getUrl().toString();
                    }
                }
            }
        }