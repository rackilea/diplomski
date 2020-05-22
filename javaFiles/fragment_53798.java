public Die(int sides) {
        this.sides = sides;
        generator = new Random();
        this.value = this.roll(this.sides);
}



public int roll(int sides) {
        this.value = generator.nextInt(sides) + 1;
        return this.value;
}