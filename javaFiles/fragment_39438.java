Function<StringJoiner, Integer> lengthFunc = new Function<StringJoiner, Integer>() {

       @Override
        public Integer apply(StringJoiner stringJoiner) {
            return stringJoiner.length;
        }
}