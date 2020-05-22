private class GeoCoderHandler extends Handler
{
    @Override
    public void handleMessage(Message msg)
    {
        switch (msg.what)
        {
            case 1:

                String address = "";
                Bundle bundle = msg.getData();

                if (bundle.getString("subThoroughFare") != null)
                {
                    if (!bundle.getString("subThoroughFare").equalsIgnoreCase("null"))
                    {
                        address = bundle.getString("subThoroughFare") + ", " +
                                bundle.getString("thoroughFare");
                    }
                }
                else
                {
                    address = bundle.getString("thoroughFare");
                }

                tvAddress1.setText("");
                tvAddress1.setText(address);

                tvAddress2.setText("");
                tvAddress2.setText(bundle.getString("subLocality"));

                tvAddress3.setText("");
                tvAddress3.setText(bundle.getString("subAdminArea"));

                edtPinCode.setText("");
                edtPinCode.setText(bundle.getString("postalCode"));

                tvCity.setText("");
                tvCity.setText(bundle.getString("city"));

                tvState.setText("");
                tvState.setText(bundle.getString("state"));

                tvCountry.setText("");
                tvCountry.setText(bundle.getString("country"));

                break;

            default:

                tvAddress1.setText(getResources().getString(R.string.address_not_found));
                tvAddress2.setText("");
                tvAddress3.setText("");
                edtPinCode.setText("");
                tvCity.setText("");
                tvState.setText("");
                tvCountry.setText("");

                break;
        }
    }
}