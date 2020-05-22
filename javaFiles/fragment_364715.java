if (CSVDataMapNew.containsKey(currentGroupNumber)) {
            csvListNew = CSVDataMapNew.get(currentGroupNumber);
            csvListNew.add(clone);
        } else {
            csvListNew = new ArrayList<>(); // that's the main required fix
            csvListNew.add(clone);
            CSVDataMapNew.put(currentGroupNumber, csvListNew);
            System.out.println(CSVDataMapNew.size());
            System.out.println(CSVDataMapNew.get(currentGroupNumber).size());
        }