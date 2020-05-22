public static void showWinkel(Winkel winkel, FragmentManager fm) {
    Bundle detailsBundle = new Bundle();
    detailsBundle.putExtra(EXTRA_WINKEL,winkel);

    Details detail= new Details();
    detail.setArguments(detailsBundle);
    fm.beginTransaction()
        .replace(R.id.mycontainer,detail)
        .addToBackStack(null)
        .commit();
}