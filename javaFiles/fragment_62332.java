1  @Override
2  public Intent getMainApplicationIntent() {
3      return new Intent(
4          Intent.ACTION_VIEW, 
5          Uri.parse(
6              getString(
7                  R.string.app_url
8              )
9          )
10     );
11 }