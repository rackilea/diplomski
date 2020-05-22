protected void onPostExecute(Void result) {
    if (!isCancelled()) { // Do stuff only if not cancelled
        FragmentActivity act = (FragmentActivity) getActivity();
        if (act != null && isAdded()) {
            act.getSupportFragmentManager().beginTransaction()
                    .add(new LoginDialogFragment(), "loginMessage").commit();
        }
    }
    return null;
}