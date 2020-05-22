Paint paint1;
Paint paint2;
Paint paint3;

List<Paint> paints = new ArrayList<Paint>();
paints.add(paint1);
paints.add(paint2);
paints.add(paint3);

for(Paint paint : paints) {
paint.setColorFilter(color);
}