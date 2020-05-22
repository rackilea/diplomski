class ItemSelectedMultiListener implements OnItemSelectedListener {

    private List<OnItemSelectedListener> mListeners = new ArrayList<>();

    public void addListener(OnItemSelectedListener listener) {
        mListeners.add(listener);
    }

    public void removeListener(OnItemSelectedListener listener) {
        mListeners.remove(listener);
    }

    @Override
    public void onItemSelected(...args...) {
        for (OnItemSelectedListener listener : mListeners) {
            listener.onItemSelected(...args...);
        }
    }

    @Override
    public void onNothingSelected(...args...) {
        for (OnItemSelectedListener listener : mListeners) {
            listener.onNothingSelected(...args...);
        }
    }
}