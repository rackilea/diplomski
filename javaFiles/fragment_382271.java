@Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setRetainInstance(true);

    appContext=(Application)getActivity().getApplicationContext();

    Intent implicit=new Intent(IDownload.class.getName());
    List<ResolveInfo> matches=getActivity().getPackageManager()
      .queryIntentServices(implicit, 0);

    if (matches.size() == 0) {
      Toast.makeText(getActivity(), "Cannot find a matching service!",
        Toast.LENGTH_LONG).show();
    }
    else if (matches.size() > 1) {
      Toast.makeText(getActivity(), "Found multiple matching services!",
        Toast.LENGTH_LONG).show();
    }
    else {
      ServiceInfo svcInfo=matches.get(0).serviceInfo;

      try {
        String otherHash=SignatureUtils.getSignatureHash(getActivity(),
          svcInfo.applicationInfo.packageName);
        String expected=getActivity().getString(R.string.expected_sig_hash);

        if (expected.equals(otherHash)) {
          Intent explicit=new Intent(implicit);
          ComponentName cn=new ComponentName(svcInfo.applicationInfo.packageName,
            svcInfo.name);

          explicit.setComponent(cn);
          appContext.bindService(explicit, this, Context.BIND_AUTO_CREATE);
        }
        else {
          Toast.makeText(getActivity(), "Unexpected signature found!",
            Toast.LENGTH_LONG).show();
        }
      }
      catch (Exception e) {
        Log.e(getClass().getSimpleName(), "Exception trying to get signature hash", e);
      }
    }
  }