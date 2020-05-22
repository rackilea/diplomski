int px = (int) p[0];
      int py = (int) p[1];
//px and py never changes.

          for(int i = 0; i < 50000 ; i++) {

            double pABC[] = {0,0};
            pABC = vc.addVectors(vc.randomVector(POINT_A,POINT_B,POINT_C),vc.multipleScalar(-1.0,p));
            p = vc.addVectors(p,vc.multipleScalar(0.5,pABC));
            synchronized (p) { //I don't think you need a synchronised call here.                  
                g2d.setColor(new Color(0,0,0));
                //px = (int)p[0] and py = (int)p[1];
                g2d.fillOval(px, py, 6, 6);
            }
      }