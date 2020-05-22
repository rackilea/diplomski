List<Integer> notInA = new ArrayList<>(listB);
listA.forEach(sm -> {
         notInA.remove(a.getServiceId());
         sm.setActive(listB.contains(sm.getServiceId()));
         listC.add(sm);
      });

notInA.forEach(id -> {
         ServiceMap newMap = new ServiceMap(id);
         newMap.setActive(true);
         listC.add(newMap);
      });