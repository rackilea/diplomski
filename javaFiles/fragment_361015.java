Interface ColorSetter {
   public void setColor(Color color);
}

class Foo implements ColorSetter {
//details omitted
}

class Bar implements ColorSetter {
//details omitted
}

List<ColorSetter> colorSetters = new ArrayList<>();
colorSetters.add(new Foo());
colorSetters.add(new Bar());

// later...
for (ColorSetter c : colorSetters) {
   c.setColor(Color.blue);
}