case R.id.menu_cleanhistory:
            ((HistoryFragment) MainActivity.this.getSupportFragmentManager()
                    .findFragmentByTag(
                            "android:switcher:" + R.id.viewpager + ":1"))
                    .cleanHistory();
           return true;