sd = map.get(c);
    if (sd != null) {
        map.remove(c);
        sd.doForget();
        if (map.size() == 0) {
            mServices.remove(context);
        }