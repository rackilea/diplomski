for(SearchHit hit : sResponse.getHits()){
            LogLineEntry entry = new LogLineEntry();
            // populate your new instance
            entry.setXyz(hit.getXyz());
            // do this for each field

            // add the instance to the list
            timeRange.add(entry);
        }