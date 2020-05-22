private WeakHashMap<NameChangedListener, String> nameChangedListenerHashMap;

    public void addNameChangedListener(
            NameChangedListener nameChangedListener) {
        if (nameChangedListenerHashMap == null) {
            nameChangedListenerHashMap = new WeakHashMap<NameChangedListener, String>();
        }
        nameChangedListenerHashMap.put(nameChangedListener,
                "entry");
    }

    private void fireNameChange() {
        if (nameChangedListenerHashMap != null) {
            Iterator<NameChangedListener> iterator = nameChangedListenerHashMap
                    .keySet().iterator();
            while (iterator.hasNext()) {
                NameChangedListener nameChangedListener = iterator.next();
                if (nameChangedListener != null) {
                    SharedPreferences pref = PreferenceManager
                            .getDefaultSharedPreferences(this);
                    String name = pref.getString("example_text", "");
                    nameChangedListener.nameChanged(name);
                }
            }
        }
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        fireNameChange();
    }