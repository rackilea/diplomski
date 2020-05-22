@Override
public void onItemClick(int p) {
    Winkel winkel = (Winkel) mijnwinkels.get(p);

     Bundle detailsBundle = new Bundle();
    detailsBundle.putExtra(EXTRA_WINKEL,winkel);

    Details detail= new Details();
    detail.setArguments(detailsBundle);
    this.getFragmentManager().beginTransaction()
            .replace(R.id.mycontainer,detail,null)
            .addToBackStack(null)
            .commit();
  }