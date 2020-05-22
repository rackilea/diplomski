public class YourOwnSender implements ReportSender {

  private String emails[];
  private Context context;

  public YourOwnSender(Context context, String[] additionalEmails){
    this.email = additionalEmails;
    this.context = context;
  }

  @Override
  public void send(CrashReportData report) throws ReportSenderException {
    StringBuilder log = new StringBuilder();

    log.append("Package: " + report.get(ReportField.PACKAGE_NAME) + "\n");
    log.append("Version: " + report.get(ReportField.APP_VERSION_CODE) + "\n");
    log.append("Android: " + report.get(ReportField.ANDROID_VERSION) + "\n");
    log.append("Manufacturer: " + android.os.Build.MANUFACTURER + "\n");
    log.append("Model: " + report.get(ReportField.PHONE_MODEL) + "\n");
    log.append("Date: " + now + "\n");
    log.append("\n");
    log.append(report.get(ReportField.STACK_TRACE));

    String body = log.toString();
    String subject = mContext.getPackageName() + " Crash Report";

    for(int i=0; i<emails.length; i++) {
      final Intent emailIntent = new Intent(android.content.Intent.ACTION_SENDTO);
    emailIntent.setData(Uri.fromParts("mailto", ACRAgetConfig().mailTo(), null));
    emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, body);
    emailIntent.putExtra(android.content.Intent.EXTRA_BCC, emails);
    mContext.startActivity(emailIntent);
    }
  }
}