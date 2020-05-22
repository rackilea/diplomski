List<Figure> figureList = new ArrayList<Figure>();
figureList.add(new Rectangle(9, 5));
figureList.add(new Triangle(10, 8));

for (Figure f : figureList) {
    System.out.println(f.area());
}