result.getResultElements().forEach(e -> {
        if( e.isResultObject() ) {
            JsonObject obj = ((GsonResultObject)e).getJsonObject();
            // do some json processing
        }
        else if( e.isResultCollection() ) {
            // do something else
        }
        else {
            System.out.println(e.getAsPrimitive());
        }
    });