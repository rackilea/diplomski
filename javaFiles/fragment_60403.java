SpannableStringBuilder eventDayOfTheWeekTxt=new SpannableStringBuilder("Today");

eventDayOfTheWeekTxt.append("(");
eventDayOfTheWeekTxt.append(eventToDisplay.getEventDate().dayOfWeek().getAsText());
eventDayOfTheWeekTxt.append(")");
eventDayOfTheWeekTxt.setSpan(new StyleSpan(Typeface.BOLD), 0, 4, 0);
contentView.setTextViewText(R.id.eventDayOfTheWeekTxt, eventDayOfTheWeekTxt);