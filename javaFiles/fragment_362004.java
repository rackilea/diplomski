int i = 0;
int polySize = 3;
List<Polygon> polyList = new List<Polygon>();
Polygon poly = new Polygon();

while (file.hasNextDouble()) {
    a = br.nextDouble();
    b = br.nextInt();
    c = br.nextInt();
    vertice = new Vertice(a, b, c);
    poly.add(vertice);

    if (i == polySize-1)
    {
        polyList.add(poly);
        poly = new Polygon();
        i = 0;
    }
    i++;
}