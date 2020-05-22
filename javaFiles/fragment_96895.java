OneSignal.postNotification(new JSONObject("{'contents': {'en': \""+ currentUser.getFullName() +" wants you to follow them." +"\"}, 'include_player_ids': ['" + selectedUser.getOneSignalId() + "']}"),
                new OneSignal.PostNotificationResponseHandler() {
                    @Override
                    public void onSuccess(JSONObject response) {
                        Log.i("OneSignalExample", "postNotification Success: " + response.toString());
                    }

                    @Override
                    public void onFailure(JSONObject response) {
                        Log.e("OneSignalExample", "postNotification Failure: " + response.toString());
                    }
                });