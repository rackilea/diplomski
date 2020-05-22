if (shuffled.isEmpty()) {
    shuffled.addAll(list);
    // Prevent the current image from been selected next...
    shuffled.remove(label.getIcon());
    Collections.shuffle(shuffled);
 }

 Icon icon = shuffled.remove(0);
 label.setIcon(icon);