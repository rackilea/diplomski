@Override
public void onPageSelected(int position) {

switch (position){

         case 0:
                tv_slider.setText(getString(R.string.es_content));
                    break;

         case 1:
                tv_slider.setText(getString(R.string.dm_content));
                    break;

         case 2:
                  tv_slider.setText(getString(R.string.ev_content));
                    break;
           .
           .
           .

            }
}