RelativeLayout mupdfWrapper;
MuPDFCore core;
public byte[] buffer;
mupdfWrapper = (RelativeLayout) viewRoot
                .findViewById(R.id.mupdf_wrapper);
        // Intent intent =new Intent(getActivity(),MuPDFActivity.class);
        // startActivity(intent);

        core = new MuPDFCore(getActivity(), buffer, "");
        MuPDFReaderView mDocView = new MuPDFReaderView(getActivity());
        mDocView.setAdapter(new MuPDFPageAdapter(getActivity(), core));
        mupdfWrapper.addView(mDocView, new LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));