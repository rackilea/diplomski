case 15:
 case 14:
 case 13:
 case 12:
 case 11:
 case 10:
 case 9:
 case 8:
 case 7:
 case 6:
 case 5:
        for(int i = -2; i <=2; i++){
            Bullet a = new Bullet((int)playerx,(int)playery+i,-i);
            bullet.add(a);
        }

    case 4:
        Bullet h = new Bullet((int)playerx, (int)playery-10, 0);
        Bullet i = new Bullet((int)playerx, (int)playery-12, 0);
        bullet.add(h);
        bullet.add(i);
    case 3:
        Bullet f = new Bullet((int)playerx, (int)playery-6, 0);
        Bullet g = new Bullet((int)playerx, (int)playery-8, 0);
        bullet.add(f);
        bullet.add(g);
    case 2:
        Bullet d = new Bullet((int)playerx, (int)playery+4, 0);
        Bullet e = new Bullet((int)playerx, (int)playery-4, 0);
        bullet.add(d);
        bullet.add(e);
    case 1:
        Bullet b = new Bullet((int)playerx, (int)playery+2, 0);
        Bullet c = new Bullet((int)playerx, (int)playery-2, 0);
        bullet.add(b);
        bullet.add(c);
    case 0:
        Bullet a = new Bullet((int)playerx, (int)playery, 0);
        bullet.add(a);
        break;

    }