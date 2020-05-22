for(int i = 0; i < distArray.size(); i++) {
    for (int j = 0; j < distArray.get(i).size(); j++) {
        // elements.add(new Element(i, distArray.get(i).get(j)));
        elements.add(new Element(j, distArray.get(i).get(j))); // ***** note change *****
    }
}