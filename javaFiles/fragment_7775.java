case R.id.bottom_navigation_map:
    if (isMapFragmentVisible) {
        break;
    } else {
        navigator.navigateToFragment(fragmentMap);
        isMapFragmentVisible = true;
    }
    return true;

case R.id.bottom_navigation_location:
    if (!isMapFragmentVisible) {
        break;
    } else {
        navigator.navigateToFragment(fragmentLocation);
        isMapFragmentVisible = false;
    }
    return true;