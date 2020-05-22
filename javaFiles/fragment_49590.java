public void saveSize() {
            Preferences preferences = Preferences.userNodeForPackage(this.getClass());
            preferences.put(getId() + X_KEY, String.valueOf(getLocation().x));
            preferences.put(getId() + Y_KEY, String.valueOf(getLocation().y));
            preferences.put(getId() + W_KEY, String.valueOf(getSize().width));
            preferences.put(getId() + H_KEY, String.valueOf(getSize().height));
            preferences.put(getId() + MAX_KEY,
                            String.valueOf((getExtendedState() & JFrame.MAXIMIZED_BOTH) == JFrame.MAXIMIZED_BOTH));
            try {
                    preferences.flush();
            }
            catch(BackingStoreException e) {
                    e.printStackTrace();
            }
    }

    public void setSavedSize() {
            Preferences preferences = Preferences.userNodeForPackage(this.getClass());
            String xs = preferences.get(getId() + X_KEY, "");
            String ys = preferences.get(getId() + Y_KEY, "");
            String ws = preferences.get(getId() + W_KEY, "");
            String hs = preferences.get(getId() + H_KEY, "");
            String max = preferences.get(getId() + MAX_KEY, "");

            if(max != null && !max.trim().isEmpty() && Boolean.valueOf(max) == true) {
                    setDefaultSize();
                    setExtendedState(JFrame.MAXIMIZED_BOTH);
                    return;
            }

            if(xs.length() == 0 || ys.length() == 0 || ws.length() == 0 || hs.length() == 0) {
                    setDefaultSize();
            }
            else {
                    sizeFromPreferences = true;
                    int x = Integer.parseInt(xs);
                    int y = Integer.parseInt(ys);
                    int w = Integer.parseInt(ws);
                    int h = Integer.parseInt(hs);
                    setLocation(x, y);
                    setSize(w, h);
            }
    }