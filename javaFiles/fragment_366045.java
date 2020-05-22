if (Gdx.input.justTouched()) {
            float xx = Gdx.input.getX();
            float yy = Gdx.input.getY();
            if (circle0.is_touched(xx, yy)) {
                // do something about circle0
            }
            if (circle1.is_touched(xx, yy)) {
                // do something about circle1
            }
            if (circle2.is_touched(xx, yy)) {
                // do something about circle2
            }
        }