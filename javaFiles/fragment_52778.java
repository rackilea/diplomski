House.HouseBuilder hb = new House.HouseBuilder();
    hb.doors(4);
    hb.windows(3);
    House h = hb.build();

    House h2 = new House.HouseBuilder().doors(4)
            .windows(3).build();