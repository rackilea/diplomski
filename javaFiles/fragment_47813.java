@Override
    public void onBindViewHolder(MySettingHolder holder, int position) {
        // Setting for one entry
        Settings setting = settingList.get(position);

        if (setting.getSettingSubtitle().equals("")) {
            holder.settingTitle.setText(setting.getSettingTitle());
            holder.settingSubtitle.setVisibility(View.GONE);
        } else {
            holder.settingSubtitle.setVisibility(View.VISIBLE);
            holder.settingTitle.setText(setting.getSettingTitle());
            holder.settingSubtitle.setText(setting.getSettingSubtitle());
        }
    }