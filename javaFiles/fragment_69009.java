g.setColor(Color.cyan);                             
int[] plainX = { i * 10, i * 10 + 10, i * 10 };     
int[] plainY = { e * 10, e * 10 + 10, e * 10 + 10 };
g.fillPolygon(plainX, plainY, plainX.length);       
g.setColor(Color.blue);                             
int[] waterX = { i * 10, i * 10 + 10, i * 10 + 10 };
int[] waterY = { e * 10, e * 10 + 10, e * 10 };     
g.fillPolygon(waterX, waterY, waterX.length);