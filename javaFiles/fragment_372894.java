for (int x = 0; x < currentScanList.size(); x++) {
            Router currentTempRouter = currentScanList.get(x);
            boolean found = false;
            for (int y = 0; y < allUniqueRoutersList.size(); y++) {
                Router allTempRouter = allUniqueRoutersList.get(y);
                if (currentTempRouter.getBssid().equals(allTempRouter.getBssid())) {
                    found = true;
                    break;
                }
            }
            if(!found){
                allUniqueRoutersList.add(currentTempRouter);
            }
        }