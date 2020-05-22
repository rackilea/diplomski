interface I1 {  }
interface I2 {  }
interface I3 {  }
interface I4 {  }

interface MyFactory {
    public <T extends I1 & I2 & I3> T createI1I2I3(); 
    public <T extends I2 & I3 & I4> T createI2I3I4(); 
}