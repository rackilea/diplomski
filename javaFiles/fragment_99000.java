String save = "";
for (int n = 0; n < checkState.length; n++) {
    if (checkState[n] != null) {
                if(checkState[n]) {
                    save = save + "true" + "|$|SEPARATOR|$|";
                } else {
                    save = save + "false" + "|$|SEPARATOR|$|";
                }
    }
}
mEditPrefs.putString("memory", save);
mEditPrefs.commit();