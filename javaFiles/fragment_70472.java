class Planet {  
  public: 
    // Enum value DECLARATIONS - they are defined later 
    static const Planet MERCURY;  
    static const Planet VENUS;  
    // ... 

  private: 
    double mass;   // in kilograms  
    double radius; // in meters  

  private: 
    Planet(double mass, double radius) {  
        this->mass = mass;  
        this->radius = radius;  
    } 

  public: 
    // Properties and methods go here 
}; 

// Enum value DEFINITIONS 
// The initialization occurs in the scope of the class,  
// so the private Planet constructor can be used. 
const Planet Planet::MERCURY = Planet(3.303e+23, 2.4397e6);  
const Planet Planet::VENUS = Planet(4.869e+24, 6.0518e6);  
// ...