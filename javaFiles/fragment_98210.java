List<MainObject> mainObjectFiltered = mainObjects.stream()
            .filter(mainObject -> {
                NestedObject nestedObject = Collections.max(mainObject.getNestedObjects(), Comparator.comparing(nestedObject -> nestedObject.getDate()));
                boolean result=businessValidation(nestedObject) || businessValidation2(nestedObject);
                System.out.println("Im am indeed filtering: "+result);
                return result;
            })
            .collect(Collectors.toList());