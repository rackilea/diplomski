public Field(RealPlayer pl1, RealPlayer pl2) {
        this.player1 = pl1;
        this.player2 = pl2;
        this.player1.setField(this);
        this.player2.setField(this);
        this.player1.self = -1;
        this.player2.self = 1;
        this.playField = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    }