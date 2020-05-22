public static Observatory findObservatoryWithHighestAverageMagnitude(
            List<Observatory> observatories, List<Earthquake> earthquakes) {

        float highestRecordedAverage = 0.0f;
        String obsnameWithHighestRecordedAverage = null;
        Map<String, List<Earthquake>> obsAndQuakes
                = mapQuakeToObs(observatories, earthquakes);
        for(String obsName: obsAndQuakes.keySet()) {
            List<Earthquake> quakesMappedToObs = obsAndQuakes.get(obsName);
            float averageMagnitude = findAverageMagnitude(quakesMappedToObs);
            if(averageMagnitude > highestRecordedAverage) {
                highestRecordedAverage = averageMagnitude;
                obsnameWithHighestRecordedAverage = obsName;
            }

        }
        for(Observatory observatory : observatories) {
            if(observatory.getObsname().equals(obsnameWithHighestRecordedAverage)) {
                return observatory;
            }
        }
        //This code won't be reached
        return null;
    }