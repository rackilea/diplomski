for (int i = 0; i < Placing_Objects.Small_Trees.size(); i++) {
        if (gotAxeOn) {
            if (player.getBounds().intersects(Placing_Objects.getSmall_Tree().get(i).getBounds())) {
                Placing_Objects.Small_Trees.get(i).health -= rand.nextInt(3);
                }
        }
        if (Placing_Objects.Small_Trees.get(i).health <= 0) {
            Placing_Objects.removeSmall_Tree(Placing_Objects.Small_Trees.get(i));
            Inventory.addItemToInv("Wood");
            Inventory.addItemToInv("Wood");
            Inventory.addItemToInv("Stick");
            Player.exp += rand.nextInt(3);
            challenges.choppedDownTrees += 1;
        }
    }