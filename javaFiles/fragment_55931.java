for (int j = 0; j < titles.size(); j++) {
    for (int k = 0; k < titles.size(); k++) {
        if (j != k && titles.get(j).contains(titles.get(k))) {
            titles.remove(k);
            if (j > k)
                j--;
            k--;
        }
    }
}