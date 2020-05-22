boolean isWordFound;
        while (s.hasNext()) {
            String temp = s.next();
            isWordFound = false;
            for (int i = 0; i < dict.size(); i++) {
                if (temp.equalsIgnoreCase(dict.get(i))) {
                    isWordFound = true;
                    System.out.println("Found"+dict.get(i)+temp);
                    break;
                }
            }
            if (!isWordFound) {
                System.out.println("Could not find"+temp);
            }

        }