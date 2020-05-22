public enum State {

    ONE {
        @Override
        public Set<State> possibleFollowUps() {
            return EnumSet.of(TWO, THREE);
        }
    },

    TWO {
        @Override
        public Set<State> possibleFollowUps() {
            return EnumSet.of(THREE);
        }
    },

    THREE // final state 

    ;
    public Set<State> possibleFollowUps() {
        return EnumSet.noneOf(State.class);
    }

}