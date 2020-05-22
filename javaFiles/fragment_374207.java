for(int i = 0 ; i < Points.size()-2;i+=2)
        {
            Point p1 = Points.get(i);
            Point p2 = Points.get(i+1);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);

        }