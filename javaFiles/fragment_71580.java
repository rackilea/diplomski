while (!queueHabitItems.isEmpty()) {
        //!! HabitItem node = queueHabitItems.peek();
        HabitItem node = queueHabitItems.remove();
        for (int i = 0; i < node.children.size(); i++) {
            HabitItem it = node.children.get(i);
            System.out.print("node: ");
            System.out.print(node.name);
            System.out.print(", child: ");
            System.out.println(it.name);
            queueHabitItems.offer(it);
        }
        // !! queueHabitItems.remove();
        System.out.println("Something Good Is Coming");
    }