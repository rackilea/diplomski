int startDateMonth = ParamUtil.getInteger(actionRequest, "startDateMonth");
int startDateDay = ParamUtil.getInteger(actionRequest, "startDateDay");
int startDateYear = ParamUtil.getInteger(actionRequest, "startDateYear");
int startDateHour = ParamUtil.getInteger(actionRequest, "startDateHour");
int startDateMinute = ParamUtil.getInteger(actionRequest, "startDateMinute");
int startDateAmPm = ParamUtil.getInteger(actionRequest, "startDateAmPm");

if (startDateAmPm == Calendar.PM) {
    startDateHour += 12;
}