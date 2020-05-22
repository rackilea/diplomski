switch (platform) {
case 0:
    p.add(new GreenPlatform(x, y));
    break;
case 1:
    p.add(new RedPlatform(x, y));
    break;
case 2:
    p.add(new BluePlatform(x, y));
    break;
case 3:
    p.add(new MagentaPlatform(x, y));
    break;
case 4:
    p.add(new GrayPlatform(x, y));
}