for (int i = 0; i < birds.size(); i++) {
        if (birds.get(i).getName().equals(name1)) {
            System.out.println("Bird already exist");
            return;
        }
    }
    birds.add(new Bird(name1, latinName1));