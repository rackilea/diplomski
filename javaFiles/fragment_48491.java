for(int i=0;i<route.length();i++) {
            JSONObject routeObject = route.getJSONObject(i);
            TrainStatus trainStatus = new TrainStatus();

            JSONObject jsonObject_station = routeObject.getJSONObject("station");

            String stationname = jsonObject_station.getString("name");
            String code = jsonObject_station.getString("code");
            Log.d("checkvalue", "   " + stationname + "    " + code);

            trainStatus.setSerialNo(routeObject.getInt("no"));
            trainStatus.setScheduleArrival(routeObject.getString("scharr"));
            trainStatus.setActualArrival(routeObject.getString("actarr"));
            trainStatus.setStatusOfArrival(routeObject.getString("status"));
            trainStatus.setHasArrived(routeObject.getBoolean("has_arrived"));
            trainStatus.setHasDeparted(routeObject.getBoolean("has_departed"));
            trainStatus.setLatemin(routeObject.getInt("latemin"));
            trainStatus.setActualArrivalDate(routeObject.getString("actarr_date"));
            trainStatus.setScheduleArrivalDate(routeObject.getString("scharr_date"));
            trainList.add(trainStatus);
        }