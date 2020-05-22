public static class Data {
            private String name;
            private String title;
            private int currentMap;
            private List<Item> items;
            private int[][] map;

            public String getName() { return name; }
            public int getCurrentMap() { return currentMap; }
            public String getTitle() { return title; }
            public List<Item> getItems() { return items; }
            public int[][] getMap() { return map; }

            public void setName(String name) { this.name = name; }
            public void setTitle(String title) { this.title = title; }
            public void setItems(List<Item> items) { this.items = items; }
            public void setMap(int[][] map) { this.map=  map; }
        }