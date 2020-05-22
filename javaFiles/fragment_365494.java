protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    // first, check that your requestCode matches the requestCode you sent to the
    // camera intent - this should really only matter if you're making multiple 
    // requests to an intent and expecting to do different things with the returns,
    // but you should check anyway.
    if (requestCode == whateverCodeYouUsedInRequest) {
        if (resultCode == RESULT_OK) {
            // everything should be OK and you can process the expected result

        } else if (resultCode == RESULT_CANCELED) {
            // user explicitly canceled the called activity - you shouldn't 
            // expect to process the expected result.
        } else {
            // not sure what happened here - but result isn't 'RESULT_OK' so 
            // you shouldn't expect to process the expected result.
        }
    }
}