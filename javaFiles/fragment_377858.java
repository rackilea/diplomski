while (responseEntityList.size() < listOfDownloadUrls.size()) {
      if (responseEntityList.size() > 0) {
        Thread.sleep(60000);
        numberOfIterations++;
      }
      for (int iterations = numberOfIterations * 20; iterations < (numberOfIterations * 20) + 20; iterations++) {

        if (responseEntityList.size() == listOfDownloadUrls.size()) {
          break;
        }