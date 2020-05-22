if (response.isSuccessful()) {
   // Get response body
} else if (response.errorBody() != null) {
   // Get response errorBody 
   String errorBody = response.errorBody().string();
}