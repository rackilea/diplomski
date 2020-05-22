service.RequestVerification(token, mobileNumber).enqueue(new CallbackHandler<ClientData<User>>() {
    @Override
    public void onSuccess(Response<ClientData<User>> response) {
        doAction();//Action must passed to this method.
        GeneralTools.hideLoading();               
    }

    @Override
    public void onFailure(@NonNull Call<ClientData<User>> call, @NonNull Throwable t) {
     GeneralTools.hideLoading();
     dialogError.show();
    }
});