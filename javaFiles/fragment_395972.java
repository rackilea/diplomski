if (lastFocused != null) {
      Container scollPane = lastFocused;
      System.out.println(scollPane);
        Container parent = scollPane.getParent();
        System.out.println(parent);
        parent.remove(scollPane);
    }
    repaint(); // repainting after removal