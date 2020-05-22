searchAdapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.suggestionrow, null, from, to, 0) {
        @Override
        public void changeCursor(Cursor cursor) {
            super.swapCursor(cursor);
        }
    };