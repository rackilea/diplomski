BiFunction<StringJoiner, CharSequence, StringJoiner> addFunc = new BiFunction<StringJoiner, CharSequence, StringJoiner>() {

       @Override
        public StringJoiner apply(StringJoiner stringJoiner, CharSequence charSequence) {
            return stringJoiner.add(charSequence);
        }
}