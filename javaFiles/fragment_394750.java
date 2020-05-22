class Buch{
    @Override
            public String toString() {
                 StringBuilder result = new StringBuilder();
                 result.append(this.name );
                 // append other properties too.
                 return result.toString();
            }
}