myGem.addAction(Actions.sequence(
                    Actions.moveTo(230f, 115f, 0.25f, Interpolation.linear),
                    new Action() {
                        public boolean act(float delta) {
                            System.out.println("Done moving myGem!");
                             scanForMatches();
                            return true;
                        }
                    }));