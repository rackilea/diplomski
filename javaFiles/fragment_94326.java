regions.sort(new Comparator<AtlasRegion>() {
            @Override
            public int compare(AtlasRegion o1, AtlasRegion o2) {
                return Integer.parseInt(o1.name) > Integer.parseInt(o2.name) ? 1 : -1;
            }
        });