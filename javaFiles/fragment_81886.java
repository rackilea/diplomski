if(counterItem.getDesc().length() == 0){
            descView.setVisibility(View.GONE);
            Log.d(HomeActivity.DEBUG_TAG, "GONE " + counterItem.getName() + ", LENGTH " + counterItem.getDesc().length());
        }else {
            **descView.setVisibility(View.VISIBLE);**
            descView.setText(counterItem.getDesc());
        }