public String printHeader() { 
    return this.print(new PrintCommand() {
        public String print(Family f) {
            return String.format(%3d", f.getId());
        }
    );
}