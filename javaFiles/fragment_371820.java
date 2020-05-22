private void loadWords() throws IOException {
            Log.d(TAG, "Loading words...");

            ArrayList<String> list = new ArrayList<String>();
            list.add("one");
            list.add("two");


            for ( String str: list){
                addWord( str, ""); // word, def.
            }
            Log.d(TAG, "DONE loading words.");
        }