public View onCreateView(LayoutInflater inflater, ViewGroup group,Bundle savedState){
    super.onCreateView(inflater,group,savedState);

   //return inflater.inflate(R.layout.fragment_home,null);
   // take this to end

    mInterstitialAd = new InterstitialAd(getActivity());
    mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
    final AdRequest adRequest = new AdRequest.Builder()
    .addTestDevice("7C77ADF1D83FA8B87C0481D6748FA4DB")
    .build();
    mInterstitialAd.loadAd(adRequest);

    mInterstitialAd.setAdListener(new AdListener() {
        @Override
        public void onAdClosed() {
          AdRequest adRequest = new AdRequest.Builder()
          .addTestDevice("7C77ADF1D83FA8B87C0481D6748FA4DB")
          .build();
          mInterstitialAd.loadAd(adRequest);
        }
    });
    return inflater.inflate(R.layout.fragment_home,null);

}