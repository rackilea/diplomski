if (stateCode != 0) {
       long duration = c.getLong(c.getColumnIndexOrThrow(KEY_DURATION));
       holder.durationView.setText(parseDuration(duration));
       holder.durationView.setVisibility(View.VISIBLE)
    } else{
       holder.durationView.setVisibility(View.INVISIBLE);
    }