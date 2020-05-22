switch (item.getItemId()) {
    case R.id.day_night:
        if (!isNight) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            isNight = true;
        } else {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            isNight = false;
        }
        break;
    }
}