final HttpEntity entity = response.getEntity();
if (entity == null) {
    Log.w(TAG, "The response has no entity.");

    //  NOTE: this method will return "" in this case, so we must check for that in onPostExecute().

    // Do whatever is necessary here...
} else {
    result = inputStreamToString(entity.getContent());
}