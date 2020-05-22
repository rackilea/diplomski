double distance = Math.abs(angle - angleTo);
if(distance > 180) {
    distance = 360 - distance;
}
//If you want, you could replace the if-statement with this line:
//distance = (distance > 180) ? 360 - distance : distance;