JSONObject parent = response;
for(...) {
    // If there's no JSON there, just make it
    if( !parent.has(keys[i]) ) {
        // It's not already in there, so let's make it
        parent.put(keys[i], new JSONObject()); // response["hello"] = {}
    }
    // Now, look at how this works. If keys = ["hello", "how", "are", "you"],
    // Then when i == 0, parent <= response["hello"]
    // That way you do response["hello"].append("how", {}) on the next iteration
    parent = (JSONObject)parent.get(keys[i]);
}