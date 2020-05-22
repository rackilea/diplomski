Hospital nearestHospital = this.getNearestAgent(main.hospitals);
Home nearestHome = this.getNearestAgent(main.homes);
Factory nearestFactory = this.getNearestAgent(main.factories);
double distanceToHospital=distanceTo(nearestHospital);
double distanceToHome=distanceTo(nearestHome);
double distanceToFactory=distanceTo(nearestFactory);

hospitalLink.disconnectFromAll();
homeLink.disconnectFromAll();
factoryLink.disconnectFromAll();

if(distanceToHospital<distanceToHome && distanceToHospital<distanceToFactory)
   hospitalLink.connectTo(neareastHospital);
else if(distanceToHome < distanceToFactory)
   homeLink.connectTo(neareastHome);
else
   factoryLink.connectTo(nearestFactory);