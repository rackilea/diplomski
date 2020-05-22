String mem = mPreferences.getString("memory", "");
mEditPrefs.putString("memory", "");
String[] array = getArray(mem); //see below for the getArray() method
checkState = new boolean[array.length];
for(int n = 0; n < array.length; n++){
    if(array[n].equals("true"){
        checkState[n] = true;
    } else {
        checkState[n] = false;
    }
}