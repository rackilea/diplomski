boolean mIsInWatcher = false;

void onTextChanged(...) {
   if (mIsInWatcher) return;
   mIsInWatcher = true;

   // text modifications here

   mIsInWatcher = false;
}