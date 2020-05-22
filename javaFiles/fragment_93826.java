class Pair {
        private final Content content;
        private final boolean isLinked;

        private Pair(Content content, boolean isLinked) {
            this.content = content;
            this. isLinked = isLinked;
        }

        public Content getContent() {
            return content;
        }

        public boolean isLinked() {
            return isLinked;
        }
    }