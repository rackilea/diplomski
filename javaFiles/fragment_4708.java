public Mission addMision( Mission mission ) {

 List<Station> stations = mission.getStations();
 mission.setStations(new ArrayList<Station>());
 for ( Station station : stations ) {
    station.setMission( mission );
    mission.getStations.add(station);
    mission = stationRepository.save( station ).getMission();
}
 return mission;
}