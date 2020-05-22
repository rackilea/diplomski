boolean hasAnyParentEntityNames(BatchIdentifier batchIdentifier) {
            return parentEntityNames.contains(batchIdentifier.getEntityName())
                    || parentEntityNames.contains(batchIdentifier.getRootEntityName());
        }

        boolean hasAnyChildEntityNames(BatchIdentifier batchIdentifier) {
            return childEntityNames.contains(batchIdentifier.getEntityName())
                    || parentEntityNames.contains(batchIdentifier.getRootEntityName());
        }