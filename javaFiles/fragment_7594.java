public Vector2D(List<List<Integer>> vec2d) {
    this.vec2d = vec2d;//assign Parameter to list
    if(this.vec2d.size() == 0) {
        this.it = null;
    } else {
        this.size = this.vec2d.size();
        System.out.println("this size is " + size); // * returns 3
        this.it = this.vec2d.get(0).iterator();   
    }
}