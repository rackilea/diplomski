Costumer requestedCostumer = null;
        while (requestedCostumer == null) {
            try {
                requestedCostumer = new Costumer(fileMap.get(input()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }