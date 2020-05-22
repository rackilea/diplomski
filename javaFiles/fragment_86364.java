public String[] toArray() {
    String[] result = new String[6];
    result[0] = this.d1;
    result[1] = this.u2.toString();
    result[2] = this.lt.toString();
    result[3] = this.ref.getd1();
    result[4] = this.ref.getu2().toString();
    result[5] = this.ref.getlt().toString();
    return result;
}