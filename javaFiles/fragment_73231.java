public int getPictureOption() {
    switch (settings.getInt(SettingsActivity.PICTURES_OPTION,
                            SettingsActivity.DEFAULT_PICTURES_OPTION)) {
            case SettingsActivity.PICTURES_4:
                return SettingsActivity.PICTURES_OPTION_0;

            case SettingsActivity.PICTURES_6:
                return SettingsActivity.PICTURES_OPTION_1;

            case SettingsActivity.PICTURES_8:
                return SettingsActivity.PICTURES_OPTION_2;
    }
}