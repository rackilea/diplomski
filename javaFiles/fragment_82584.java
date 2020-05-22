public void reflect(Hole h){
    //R = -2*(V dot N)*N + V
    //N is normalized.
    double nx = (this.position[0]+this.diameter/2) - (h.x+16);
    double ny = (this.position[1]+this.diameter/2) - (h.y+16);
    double nd = Math.hypot(nx, ny);
    if (nd == 0)
        nd = 1;
    nx /= nd;
    ny /= nd;
    double dotProduct = this.speed[0]*nx+this.speed[1]*ny;
    this.speed[0] += (float)(-2*dotProduct*nx);
    this.speed[1] += (float)(-2*dotProduct*ny);
}

public void reflectResponse() {
    for (int i = 0; i <= 1; i++) {
        position[i] -= speed[i];
        speed[i] *= 0.992f;
    }
}