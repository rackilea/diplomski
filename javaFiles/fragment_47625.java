class _UserSignupInterface extends _SignupSelectUsernamePageState
    implements UserSignupInterface {
  void Function(_UserSingupInterface self) _onSuccess;
  void Function(_UserSingupInterface self) _onError;
  _UserSignupInterface(this._onSuccess, this._onError);

  @override
  void onSuccess() { 
    _onSuccess(this);
  }

  @override
  void onError() {
    _onError(this);
  }
}