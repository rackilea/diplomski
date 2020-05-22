if(hosebirdClient.isDone())
        {
            hosebirdClient.stop();
            updateSystmeParameters(0, getCurrentTimeStamp(), "NA");
            Search.startFirehoseFilter(); // this function restart the thread 

        }