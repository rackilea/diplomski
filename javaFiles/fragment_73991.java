BookImages bImages = null;
        Domains domains = null;
        Defaults defaults = null;
        List<String> domain = null;
        String firstDomain = null;

        if ((bImages = book.getBookImages()) != null
                && (domains = bImages.getDomains()) != null
                && (defaults = domains.getDefaults()) != null
                && (domain = defaults.getDomain() != null
                && domain.size() > 0) {

                        firstDomain = domain.get(0);

        }