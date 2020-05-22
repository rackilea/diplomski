@Override
public void onStampResult(StampResult result) {
    if (result.error == null){
        SnowShoeStamp stamp = result.stamp;
        // Process stamp
    } else {
        SnowShoeError error = stampResult.error;
        // Process error
    }
}