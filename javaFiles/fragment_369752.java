getterList.add(homeGetter);

Collections.sort(homeGetter, new Comparator<HomeGetter>() {
            public int compare(HomeGetter s1, HomeGetter s2) {
                return Integer.compare(Integer.parseInt(s1.getLocation()), Integer.parseInt(s2.getLocation()));
            }
        });

homeAdapter.notifyDataSetChanged();