// Pseudo code
  for (double t = 0; t < 2 * PI; t += 0.001) { // <- or different step
    double x = RadiusX * Math.Cos(t);
    double y = RadiusY * Math.Sin(t);

    Paint(x, y);
  }