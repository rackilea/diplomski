public synchronized void filter(CharSequence s) {
        if (s == null || s.toString().trim().isEmpty()) {
            if (mFiltered != null) {
                mFiltered = null;
                notifyDataSetChanged();
            }
        } else {
            if (mFiltered != null)
                mFiltered.clear();
            mFiltered = new ArrayList<>();
            mFilteredNames = new ArrayList<String>();
            for (int i = 0; i < stringList.size(); i++) {
                final String name = stringList.get(i);
                if (name.toLowerCase(Locale.getDefault())
                        .startsWith(s.toString().toLowerCase(Locale.getDefault()))) {
                    mFiltered.add(drawables.get(i));
                    mFilteredNames.add(name);
                }
            }
            notifyDataSetChanged();
        }