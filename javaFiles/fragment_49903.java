class Bar extends Foo {
    public boolean equals(Object other) {
        if (other instanceof Bar) {
             Bar that = (Bar)other;
             return that.canEqual(this) && otherStuff;
        }            
        return false;
    }

    public boolean canEqual(Object other) {
          return other instanceof Bar;
    }
}