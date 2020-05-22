protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    // TODO Auto-generated method stub
    super.onActivityResult(requestCode, resultCode, data);
    StringBuilder sBuilder = new StringBuilder();
    ArrayList<String> temp = new ArrayList<String>();
    temp = data.getStringArrayListExtra("intentReturn");
    for(int i = 0; i < temp.size(); i++){
        sBuilder.append(temp.get(i).toString());
        if(i < temp.size() - 1){
            sBuilder.append(", ");
        }
    }
    tvResult.setText(sBuilder.toString());
}