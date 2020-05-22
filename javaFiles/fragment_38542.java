private void generateParamList(String pageId) {
    // Don't process duplicates
    if (params.contains(pageId)) return;

    // Store links not processed
    Stack<String> links = new Stack<String>();

    // Store current pageId to be processed
    links.push(pageId);

    // Loop, processed the Stack link, not a recursive call
    while (!links.empty()) {
        pageId = links.pop();

        // Link already processed
        if (params.contains(pageId)) continue;

        params.add(pageId);

        // Get list of the inbound pages
        String[] inc = getInboundLinks(pageId);

        for (int i = 0; i < inc.length; i++) {
            // Store link to be processed by the loop
            links.push(inc[i]);
        }
    }
}