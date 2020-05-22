private CompoundButton.OnCheckedChangeListener checkedListener = new CompoundButton.OnCheckedChangeListener() {                      
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            // TODO Auto-generated method stub
                       int getPosition = (Integer) v.getTag();  // Here we get the position that we have set for the checkbox using setTag.
                       boolean flag= list.get(getPosition).isCheck();
                       for (int i = 0; i < list.size(); i++) {
                       if (getPosition == i) {
                       list.get(getPosition).setCheck(true);
                       } else {
                       list.get(getPosition).setCheck(false);
                       }
                       }

                     notifyDataSetChanged();
                    });;