@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == 101) {
        if(resultCode == RESULT_OK){
            int responseInt =   data.getIntExtra("SUBMIT_DATA",-2);
            if(responseInt>=0){
                mAdapter.updateItemAt(responseInt);
            }
        }
    }
}