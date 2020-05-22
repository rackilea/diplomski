// Create new LayoutParams object
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

// Define values in dp and calculate pixels from it because margins are with pixels
int dpValueBottom = 14;
int dpValueLeft = 40;
float d = customContext.getResources().getDisplayMetrics().density;
int marginStandard = (int)(dpValueBottom * d);
int marginLeft = (int)(dpValueLeft * d);

holder.settingImage.setImageResource(setting.getSettingImageUrl());
// If the settingSubtitle is empty it should be not visible and just the settingTitle
if (setting.getSettingSubtitle().equals("")) {
    holder.settingTitle.setText(setting.getSettingTitle());
    holder.settingSubtitle.setVisibility(View.GONE);

    // Get settingTitle TextView
    TextView settingTitle = holder.settingTitle;

    // Set margin to params
    params.setMargins(marginLeft, marginStandard, 0, marginStandard);

    // Set params to settingTitle
    settingTitle.setLayoutParams(params);

} else {
    holder.settingTitle.setText(setting.getSettingTitle());
    holder.settingSubtitle.setText(setting.getSettingSubtitle());
}