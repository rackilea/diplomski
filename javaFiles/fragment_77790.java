public static final String getLocalizedString(int resId) {
  if(Locale.getDefault().toString().equals("fa_IR")) {
       return PersianReshape.reshape(getResources().getString(resId));
  }else{
      return getResources().getString(resId);
}