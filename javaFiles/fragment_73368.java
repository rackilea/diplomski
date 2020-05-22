public class CustomListAdapter extends ArrayAdapter<String> {


    private NativeExpressAdView adView;

    private NativeExpressAdView getAddView() {
        if (adView != null) {
            return adView;
        }
        adView = new NativeExpressAdView(context);

        adView.setAdUnitId("[your unit id]");
        adView.setAdSize(new AdSize(AdSize.FULL_WIDTH, 80));

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        adView.setLayoutParams(layoutParams);
        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd(request);

        return adView;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.layout_add, null, true);

//        NativeExpressAdView adView = (NativeExpressAdView) rowView.findViewById(R.id.adView);

        LinearLayout linearLayout = (LinearLayout) rowView.findViewById(R.id.addView);

        linearLayout.removeAllViews();
        TextView txtTitle = (TextView) rowView.findViewById(R.id.number);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imgid);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);


        txtTitle.setText(numbers[position]);
        imageView.setImageResource(imgid[position]);
        extratxt.setText("Number: " + numbers[position]);

        if (position == 2) {
            linearLayout.addView(getAddView());
            linearLayout.setVisibility(View.VISIBLE);
        } else {
            linearLayout.removeAllViews();
            linearLayout.setVisibility(View.GONE);
        }

        return rowView;

    }

    ;
}