Bundle postStatusMessage = new Bundle();

// ADD THE STATUS MESSAGE TO THE BUNDLE
postStatusMessage.putString("message", "Let's hangout at " + placeName);
postStatusMessage.putString("link", "www.the_example_web_address.com");

Utility.mAsyncRunner.request("me/feed", postStatusMessage, "POST", new StatusUpdateListener(), null);