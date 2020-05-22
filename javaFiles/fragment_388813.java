MotionState motionState=MotionState.NONE;

enum MotionState {

    NONE {
        @Override
        public boolean update(Rectangle player) {
           return true;
        }
    },

    UP {
        @Override
        public boolean update(Rectangle player) {
            player.y += 300 * Gdx.graphics.getDeltaTime();
            return false;
        }
    },

    DOWN{
        @Override
        public boolean update(Rectangle player) {
            player.y -= 300 * Gdx.graphics.getDeltaTime();
            return false;
        }
    },

    LEFT{
        @Override
        public boolean update(Rectangle player)  {
            player.x -= 300 * Gdx.graphics.getDeltaTime();
            return false;
        }
    },

    RIGHT{
        @Override
        public boolean update(Rectangle player) {
            player.x  += 300 * Gdx.graphics.getDeltaTime();
            return false;
        }
    };

    public abstract boolean update(Rectangle player);
}