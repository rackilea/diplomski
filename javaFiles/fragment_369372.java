public void setBrakes (BrakeType aBrake) {
       if (aBrake == BrakeType.Caliper || 
          aBrake == BrakeType.Cantilever || 
          aBrake == BrakeType.LinearPull || 
          aBrake == BrakeType.Disc) {
                  brakes = aBrake;
        } 
       else throw new IllegalArgumentException("invalid");
 }