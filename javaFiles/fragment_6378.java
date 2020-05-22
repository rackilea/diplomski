public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == REEQUEST_CODE_IMPORT) {
            // Make sure the request was successful
            Uri path = data.getData();

            if (resultCode == RESULT_OK && path != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    try (InputStream inputStream = getActivity().getContentResolver().openInputStream(path);
                         BufferedReader reader = new BufferedReader(
                                 new InputStreamReader(Objects.requireNonNull(inputStream)))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            Log.d(TAG, line);
                            stringBuilder.append(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String content = stringBuilder.toString();
                    // Do something with it
            }
        }
    }