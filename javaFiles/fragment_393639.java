public SearchManager(ILog logger, String basePath, String indexPath, String nwId, IMail mailerarg) {
        this.logger = logger;
        this.basePath = basePath;
        this.indexPath = indexPath;
        this.nwId = nwId;
        mailer = mailerarg;
    }