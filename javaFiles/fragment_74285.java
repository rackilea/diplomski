public float Location(Double lattitude,Double longitude)
    {
        Double lat2=24.927437;
        Double lng2=67.094412;

          List<RiderLocation> allRidersLocation  = riderLocationRepository.findAll();
          for (RiderLocation riderLocation : allRidersLocation) {
            float distance=distFrom(riderLocation.getLattitude(), riderLocation.getLongitude(), lat2, lng2);
            System.out.println("Distance : " + (distance/1000));
            return distance;
    }
    }