onCreate

fragment = getSupportFragmentManager().findFragmentByTag(TAG);
if (fragment == null) {
    fragment = new TransactionsFragment();
}