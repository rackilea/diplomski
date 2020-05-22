CartesianChart modelo = new CartesianChart();

modelo.setLabel("Label");

ChartSeries s = ChartSeries();

s.set(">90 días", v.getVencidoMasTresMeses());
s.set("90 y 60 días", v.getVencidoTresMeses());
s.set("60 y 30 días", v.getVencidoDosMeses());
s.set("30 y 1 día", v.getVencidoMes());
s.set("1 a 30 días", v.getTreintaDias());
s.set("30 a 60 días", v.getSesentaDias());
s.set("60 a 90 días", v.getNoventaDias());

modelo.add(s);
modelo.setTitle("Title");