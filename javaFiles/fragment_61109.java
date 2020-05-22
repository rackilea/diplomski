@Override 
public void onPostExecute(ApiResponse result) {
    if (apiResponse != null && apiResponse.isSuccess()) {
        if (this.callback != null) {
            callback.onPasswordChanged(this.oldPassword, this.newPassword);
        } else {
            Log.w("Password change", "Password callback not set!");
        }
    } else {
        // TODO: Error handling
    }
}