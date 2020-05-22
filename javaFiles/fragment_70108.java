Iterator<String> itr = valueArrayList.iterator();
while (itr.hasNext()) {
    // If file doesn't exist
    if (!validateFile(itr.next())) {
        itr.remove(); // delete from list
        Log.d(LOG_TAG, "values removed");
    }
}