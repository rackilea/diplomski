private native void attachInternal() /*-{
  var that = this;
  $wnd.jQuery("div.datePickerDay.datePickerDayIsValue").on( "click", function() {
    that.@com.booxi.admin.client.common.ui.text.DateFormatter::uiDatePickerPopup.hide()();
    console.log("OK");
  });
}-*/;