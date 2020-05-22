public class LaporanFragment extends Fragment {

  private LaporanListener mListener;

  // Define a Listener to 'speak up' to the main activity
  public interface LaporanListener {
      public void onSendReportClicked(String title, String content, String idNumber);
   }
  ...
}