public interface OnGetUserCallback {
    void onGetUser(User user);

    void onError(Throwable t);
}

public static void getUserById(Integer userId, OnGetUserCallback onGetUserCallback) {
    Call<User> call = service.getUser(userId);

    call.enqueue(new Callback<User>() {
        @Override
        public void onResponse(Call<User> call, Response<User> response) {
            onGetUserCallback.onGetUser(response.body());
        }

        @Override
        public void onFailure(Call<User> call, Throwable t) {
            onGetUserCallback.onError(t);
        }
    });
}