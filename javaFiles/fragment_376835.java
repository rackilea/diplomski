private OnClickListener onClickListener = new OnClickListener() {
    @Override
    public void onClick(View v){
        switch(v.getId()){

            case R.id.btGlobex:
                Intent intent1 = new Intent(getActivity(), GlobexActivity.class);
                startActivity(intent1);//Edited here
                break;
            case R.id.btUmbrella:
                Intent intent2 = new Intent(getActivity(), UmbrellaActivity.class);
                startActivity(intent2);//Edited here
                break;
        }
    }
}