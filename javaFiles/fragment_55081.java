try {
                    valA = a.getDouble(KEY_NAME);
                } catch (JSONException e) {
                    Log.e("MainActivity", e.getMessage());
                }
                try {
                    valB = b.getDouble(KEY_NAME);
                } catch (JSONException e) {
                    Log.e("MainActivity", e.getMessage());
                }

                return Double.compare(valA,valB);