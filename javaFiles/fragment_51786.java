void deleteCharsInPath() {
    for (List<TextPosition> list : charactersByArticle) {
        List<TextPosition> toRemove = new ArrayList<>();
        for (TextPosition text : list) {
            Matrix textMatrix = text.getTextMatrix();
            Vector start = textMatrix.transform(new Vector(0, 0));
            if (linePath.contains(start.getX(), start.getY())) {
                toRemove.add(text);
            }
        }
        if (toRemove.size() != 0) {
            System.out.println("Removed " + toRemove.size() + " TextPosition objects as they are being covered.");
            list.removeAll(toRemove);
        }
    }
}