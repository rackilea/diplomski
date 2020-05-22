switch(i) {
    case 0:
        preferences.edit().putInt(SELECTED_SIZE, 16).apply();
        break;
    case 1:
        preferences.edit().putInt(SELECTED_SIZE, 18).apply();
        break;
    // other cases go here...
}