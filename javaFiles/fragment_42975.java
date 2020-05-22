// This is a bad idea...
        if (s != previousSec) {

            dhs = Math.toRadians(s * 6 - 90);
            secx = (int) (secRadius * Math.cos(dhs)) + center;
            secy = (int) (secRadius * Math.sin(dhs)) + center;

            pointx1 = (int) ((secRadius + center * 0.15) * Math.cos(dhs)) + center;
            pointy1 = (int) ((secRadius + center * 0.15) * Math.sin(dhs)) + center;


            m = new Date().getMinutes();
            dhm = Math.toRadians(m * 6 - 90);
            minx = (int) (minRadius * Math.cos(dhm)) + center;
            miny = (int) (minRadius * Math.sin(dhm)) + center;

            pointx2 = (int) ((secRadius + center * 0.15) * Math.cos(dhm)) + center;
            pointy2 = (int) ((secRadius + center * 0.15) * Math.sin(dhm)) + center;


            h = new Date().getHours();
            dhh = Math.toRadians(h * 30 - 90 + ((m - 1) / 2));
            hrx = (int) (hrRadius * Math.cos(dhh)) + center;
            hry = (int) (hrRadius * Math.sin(dhh)) + center;

            repaint();
            previousSec = s;
        }