public boolean onQueryTextChange(final String newText) {

            if (newText.length() > 3) {

                if (canRun) {
                    canRun = false;
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            canRun = true;
                            handleLocationSearch(newText);
                        }
                    }, 500);
                }
            }

            return false;
        }