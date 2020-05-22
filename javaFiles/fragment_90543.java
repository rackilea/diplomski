List<DocumentResult> documentResults = objects.getObject().stream()
                .map(objectType -> {
                         String[] keys = objectType.getStorageKey().getObjectName().split("/");
                         DocumentResult result = new DocumentResult(DocCategories.valueByLabel(keys[1]), DocCategoryGroups.valueByLabel(keys[2]), DocSubCategories.valueByLabel(keys[3]), keys[4], keys[5]);
                         result.setLink(objectType.getTempUrl().getFullUrl());
                         return result;
                     })
                .collect(Collectors.toList());