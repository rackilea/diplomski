public class StatusFragment extends Fragment implements Callback<ResponseBody> {   

    private ServiceCalls serviceCalls;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Setting the implementation
        serviceCalls = ServiceCalls.getInstance();
        serviceCalls.setNetworkCallsimpl(new NetworkCallsRetrofitImpl());
    }

    private void updateStatus() {
        serviceCalls.getDataFromServer("http://site.example/status", this);
    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        String response = response.body().toString();
        Toast.makeText(getActivity(), response, TOAST.LENGTH_SHORT).show();
    }

     @Override
     public void onFailure(Call<ResponseBody> call, Throwable t) {
         Log.e("err", t.getMessage());
     }
}