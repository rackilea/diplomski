for (ResultWithQuery resQuery: list) {
        try {
            resQuery.getQuery();
            List<SearchResult> sr = resQuery.getFuture.get();
        } catch (InterruptedException ex) {
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }