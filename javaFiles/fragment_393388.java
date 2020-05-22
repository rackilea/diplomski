SafetyNet.getClient(this).verifyWithRecaptcha("YOUR_API_SITE_KEY")
            .addOnSuccessListener(new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
                @Override
                public void onSuccess(SafetyNetApi.RecaptchaTokenResponse recaptchaTokenResponse) {
                    // Indicates communication with reCAPTCHA service was
                    // successful.
                    String userResponseToken = recaptchaTokenResponse.getTokenResult();
                    if (!userResponseToken.isEmpty()) {
                        // Validate the user response token using the
                        // reCAPTCHA siteverify API.
                        Log.e(TAG, "VALIDATION STEP NEEDED");
                    }
                }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    if (e instanceof ApiException) {
                        // An error occurred when communicating with the
                        // reCAPTCHA service. Refer to the status code to
                        // handle the error appropriately.
                        ApiException apiException = (ApiException) e;
                        int statusCode = apiException.getStatusCode();
                        Log.e(TAG, "Error: " + CommonStatusCodes
                                .getStatusCodeString(statusCode));
                    } else {
                        // A different, unknown type of error occurred.
                        Log.e(TAG, "Error: " + e.getMessage());
                    }
                }
            });