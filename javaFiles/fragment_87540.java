private void makeTelCall(String telNumber){
        try{
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+telNumber));
            startActivity(intent);
        }
        catch(SecurityException se){
            openAppDetailSettings();
            String mess = "Permission for telephone calls has not been granted!";
            Toast.makeText(this, mess, Toast.LENGTH_LONG).show();
            Log.e(TAG, se.getMessage());
        }
        catch (Exception ex){
            Log.e(TAG, ex.getMessage());
        }
    }