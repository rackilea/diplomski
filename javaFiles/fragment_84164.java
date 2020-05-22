JsonNode data = node.path("data");
if (!data.isMissingNode()) {  // checks if data exists
    if (data.iterator().hasNext()) {  // checks if data is not empty
        // get first child ("unwrap")
        JsonNode firstNodeInsideData = data.iterator().next(); 
    }
}