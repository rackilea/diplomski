if (response.isEmpty()) {

            SharedPreferences sharedPreferencesMatchingContactsAsArrayList = PreferenceManager.getDefaultSharedPreferences(getApplication());
            SharedPreferences.Editor editorMatchingContactsAsArrayList = sharedPreferencesMatchingContactsAsArrayList.edit();
            editorMatchingContactsAsArrayList.putString("MatchingContactsAsArrayList", "");
            editorMatchingContactsAsArrayList.commit();
          } else {