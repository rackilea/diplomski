public class MainActivity extends Activity implements LaporanFragment.LaporanListener {

   ...

   @Override
   public void onSendReportClicked(String title, String content, String idNumber) {
     // MainActivity will receive the data here.
     // You need to process here.
   }

  ...
}