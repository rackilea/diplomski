f = cache.putIfAbsent(arg, ft);

        if (f == null) {
            f = ft;
            ft.run();
        }