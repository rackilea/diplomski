@Override
public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {
    long _bytesCurrent = bytesCurrent;
    long _bytesTotal = bytesTotal;

    float percentage = (int) ((float)_bytesCurrent /(float)_bytesTotal * 100);
    Log.d("percentage","" + percentage);
   adapter.updateProgress(percentage, position);// pass adapter list item position here 
}