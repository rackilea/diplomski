public String getTestMe(@PathVariable("timestamp") String timestamp) {

            if (timestamp != null && isValidIsoDateTime(timestamp))        {
               return HARDCODED_TEST_VALUE;       
            }
            throw new ResourceNotFoundException("wrong timestamp format");


        }