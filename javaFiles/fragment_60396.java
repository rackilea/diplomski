Random random = ...
...
List<Integer> minDistanceIndices = new ArrayList<>();

double smallestDistance = 0.0;
for (int i = 0; i < unsolvedOutlets.size(); i++) {
    double newDistance = Math.sqrt(
        (unsolvedOutlets.get(i).getLatitude() - currSolved.getLatitude())*
        (unsolvedOutlets.get(i).getLatitude() - currSolved.getLatitude())+
        (unsolvedOutlets.get(i).getLongitude() - currSolved.getLongitude())*
        (unsolvedOutlets.get(i).getLongitude() - currSolved.getLongitude()));
    distances.add(newDistance);
    if (newDistance < smallestDistance) {
         minDistanceIndices.clear();
         minDistanceIndices.add(i);
         smallestDistance = newDistance;
    } else if (newDistance == smallestDistance) {
         minDistanceIndices.add(i);
    }                             
}

if (!unsolvedOutlets.isEmpty()) {
     int index = minDistanceIndices.get(random.nextInt(minDistanceIndices.size()));
     Object chosenOutlet = unsolvedOutlets.get(index);
     System.out.println("chosen outlet: "+ chosenOutlet);
}