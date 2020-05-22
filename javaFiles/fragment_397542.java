ArrayList<String> available = data
                .getStringArrayListExtra("availableVoices");
        Log.v("languages count", String.valueOf(available.size()));
        Iterator<String> iter = available.iterator();
        while (iter.hasNext()) {
            String lang = iter.next();
            Locale locale = new Locale(lang);
            Log.v(TAG, "language: " + lang);
            Log.v(TAG, "language locale: " + locale.toString());

            TextView LocaleResults = (TextView) getView().findViewById(
                    R.id.textViewConfig);
            LocaleResults.append("\nAvailable Engine Language: " + lang);

        }

        ArrayList<String> unavailable = data
                .getStringArrayListExtra("unavailableVoices");
        Log.v("languages count", String.valueOf(unavailable.size()));
        Iterator<String> iteru = unavailable.iterator();
        while (iteru.hasNext()) {
            String ulang = iteru.next();
            Locale ulocale = new Locale(ulang);
            Log.v(TAG, "ulanguage: " + ulang);
            Log.v(TAG, "ulanguage locale: " + ulocale.toString());

            TextView LocaleResults = (TextView) getView().findViewById(
                    R.id.textViewConfig);
            LocaleResults.append("\nUnavailable Engine Language: " + ulang);

        }