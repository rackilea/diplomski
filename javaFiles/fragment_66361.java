Point a_from, a_to;
Point b_from, b_to;
Point res_from =  new Point();
Point res_to =  new Point();
res_from.SetX(Math.max(a_from.getX(), b_from.getX()));
res_to.SetX(Math.min(a_to.getX(), b_to.getX()));