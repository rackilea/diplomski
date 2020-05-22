private void handleResponse(Response<User> response) {
        if (response.isSuccessful()) {
            User user = response.body()
        } else {
            // some code
        }
    }