return content.create().flatMap(backendEntity -> {
            Content newContent = (Content) backendEntity;
            newContent.setEntityId(backendEntity.getEntityId());
            newContent.setSchema(content.getSchema());
            return Single.just(newContent);
        }).flatMap(content1 -> {
            return content1.setLink("schema", content1.getSchema().getEntityId())
                .flatMap(isLinked -> Single.just(new Pair(content1, isLinked)));
        }).flatMap(pair -> {
            // Code section 1
            // ** here you can access pair.getContent() and pair.isLinked()
            return Single.just(true); // just a dummy to  illustrate
        })