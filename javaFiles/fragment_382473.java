Paging paging = new Paging();
    paging.setCount(200);

    List<Status> statuses = twitter.getHomeTimeline(paging);
    for (Status status : statuses) {
        MediaEntity[] media = status.getMediaEntities();
        ExtendedMediaEntity[] extendedMediaEntities = status.getExtendedMediaEntities();
        for (int i = 0; i < extendedMediaEntities.length; i++) {
            ExtendedMediaEntity extendedMediaEntity = extendedMediaEntities[i];
            ExtendedMediaEntity.Variant[] variant = extendedMediaEntity.getVideoVariants();
            if (extendedMediaEntity.getType().equals("video")) {
                for (int j = 0; j < variant.length; j++) {
                    System.out.println("variant url: " + variant[j].getUrl());
                }
                String url = extendedMediaEntity.getURL();
                System.out.println("extended url: " + extendedMediaEntity.getExpandedURL());
            }
        }
    }