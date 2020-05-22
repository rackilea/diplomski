public void showSchedule() {


BottomSheetFrag bottomSheetFragment = new BottomSheetFrag();

bottomSheetFragment.setClickListner(new OnclickDataLisnter(){
                                       @Overrid
                                        public void onClick(String data){
                                         //You listner here your data
                                         }
                                    }
Bundle bundle = new Bundle();
bundle.putString("UserId", Parlour_BeauticianID);

bottomSheetFragment.setArguments(bundle);
bottomSheetFragment.show(getSupportFragmentManager(), 
bottomSheetFragment.getTag());