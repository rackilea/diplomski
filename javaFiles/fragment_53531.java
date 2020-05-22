List<ProductoAseo> miProductoAseo = new ArrayList<ProductoAseo>();
miProductoAseo.add(new ProductoAseo(app, miAseo[0], miAseoPrecio[0], 430, 360, 8000));
miProductoAseo.add(new ProductoAseo(app, miAseo[1], miAseoPrecio[1], 675, 360, 25000));
miProductoAseo.add(new ProductoAseo(app, miAseo[2], miAseoPrecio[2], 920, 360, 5500));
int sum = 0;
for (ProductoAseo p : miProductoAseo) {
    sum += p.price();
}