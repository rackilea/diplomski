private void loadLogo(List<String> list) {
        drawables = new ArrayList<>();

        for (String extra : list) {
            int res = r.getIdentifier(extra, "drawable", p);
            if (res != 0) {
                final int brandInt = r.getIdentifier(extra, "drawable", p);
                if (brandInt != 0)
                    drawables.add(brandInt);
            }
        }
    }