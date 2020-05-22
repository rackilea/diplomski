SimpleDateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);
        try {
            volcanoListDate = df.parse(currentValue.replaceAll("\\p{Cntrl}", ""));
        } catch (ParseException e) {
            Log.d("VOLCANO_DEBUG", e.toString());
            Log.d("VOLCANO_DEBUG", currentValue);
        }