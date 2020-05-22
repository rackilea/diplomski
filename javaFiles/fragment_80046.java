@Override
public void onClick(View v) {
    switch (v.getId()){
        case R.id.aButton:
            //select the index of AFragment:
            ((MainActivity)getActivity()).selectIndex(1);
            break;
    }
}