class Particle {
  
    constructor(l) {
        this.acceleration = createVector(0, 0);
        this.velocity = createVector(0,0);//random(-0.0001, 0.00001), random(-0.001, 0.0001));
        this.position = l ? l.copy() : createVector(Math.random()*1200, Math.random()*1200,);
        this.home = this.position.copy();
    }

    run() {
        this.update();
        this.display();
    }

    // Method to update position
    update() {
        this.acceleration.x = -0.01*(this.position.x - this.home.x);
        this.acceleration.y = -0.01*(this.position.y - this.home.y);
        this.velocity.add(this.acceleration);
        this.velocity.mult(0.9);
        this.position.add(this.velocity);
        //   lifespan -= 1.0;
    }

    // Method to display
    display() {
        noStroke();//stroke(255, lifespan);
        //fill(255, lifespan);
        fill(0);
        ellipse(this.position.x, this.position.y, 25, 25);
    }
}

class ParticleSystem {
    constructor(position) {
        this.origin = position.copy();
        this.particles = [];
    }

    addParticle() {
        //this.particles.push(new Particle(this.origin));
        this.particles.push(new Particle());
    }

    run() {
        for (let i = this.particles.length-1; i >= 0; i--) {
            this.particles[i].run();
    //      if (p.isDead()) {
            //    particles.remove(i);
    //      }
        }
    }

    move_away_from(x, y){
        for (let i = 0; i < this.particles.length; i++) {
            let p = this.particles[i];
            let d = dist(x,y, p.position.x, p.position.y);
            if( d < 200 ){ 
                p.velocity.x += map(d,0,200,0.5,0.1)*(p.position.x - x);
                p.velocity.y += map(d,0,200,0.5,0.1)*(p.position.y - y);
            }
        }
    }
}

var ps;

function setup() {
    createCanvas(1200, 800);
    ps = new ParticleSystem(createVector(width/2, 50));
    for (var i=0; i<1200; i++) {
        ps.addParticle();
    }
}

function draw() {
    background(255);
    ps.move_away_from(mouseX, mouseY);
    ps.run();
}