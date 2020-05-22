class DensityBox{

    float weight, volume;

    DensityBox(float weight, float volume){
        this.weight = weight; // check >0
        this.volume = volume; //check >=0
    }

    float getDensity() {  return volume/weight;   }
 }