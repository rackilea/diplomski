List<Point> points = new ArrayList<Point>();
points.add(new Point(2,3));
points.add(new Point(3,4));
points.add(new Point(4,5));

Map<String, Object> nameCtx = new HashMap<String, Object>();
nameCtx.put("buzBeanCollection", points);

Object result = MVEL.eval("((new org.my.MyKey('job12', $.x * 2, $.y * 2)) in buzBeanCollection)", nameCtx);
System.out.println(result);