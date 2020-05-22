int route = 396; // [km]
            int speed = 100; // [km/h]
            float time = (float) route / (float) speed;
            int hours = (int) time;
            int minutes = (int) (60 * (time - hours));
            System.out.println(hours + "h " + minutes + "m");