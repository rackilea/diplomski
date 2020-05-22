Status BinderUpdateEngineAndroidService::bind(
    const android::sp<IUpdateEngineCallback>& callback, bool* return_value) {
  callbacks_.emplace_back(callback);
  const android::sp<IBinder>& callback_binder =
      IUpdateEngineCallback::asBinder(callback);
  auto binder_wrapper = android::BinderWrapper::Get();
  binder_wrapper->RegisterForDeathNotifications(
      callback_binder,
      base::Bind(
          base::IgnoreResult(&BinderUpdateEngineAndroidService::UnbindCallback),
          base::Unretained(this),
          base::Unretained(callback_binder.get())));
  // Send an status update on connection (except when no update sent so far),
  // since the status update is oneway and we don't need to wait for the
  // response.
  if (last_status_ != -1)
    callback->onStatusUpdate(last_status_, last_progress_);
  *return_value = true;
  return Status::ok();
}