public class FacebookSuggestOracle extends SuggestOracle {

    private FacebookServiceAsync service = GWT.create(FacebookService.class);
    private Request currentRequest;
    private Callback currentCallback;

    @Override
    public void requestSuggestions(Request request, Callback callback) {
        // Save request & callback for future use.
        this.currentRequest = request;
        this.currentCallback = callback;

        // Fetch the groupIds
        service.getFacebookGroupIds(request.getQuery(), new AsyncCallback<List<String>>() {
            public void onSuccess(List<String> result) {
                createSuggestionsForGroupIds(result);
            }

        });

    }

    private void createSuggestionsForGroupIds(List<String> groupIds) {
        List<FacebookGroupSuggestion> suggestions = new ArrayList<FacebookGroupSuggestion>();
        for (String groupId : groupIds) {
            suggestions.add(new FacebookGroupSuggestion(groupId));
        }
        Response response = new Response(suggestions);
        // Tell the suggestBox to display some new suggestions
        currentCallback.onSuggestionsReady(currentRequest, response);

        // Fetch the icons
        for (String groupId : groupIds) {
            service.getIconForGroup(groupId, new AsyncCallback<Icon>() {

                public void onSuccess(Icon result) {
                    // match the icon to the groupId in the suggestion list
                    // use the callback again to tell the display to update itself

                }

            });
        }
    }
}