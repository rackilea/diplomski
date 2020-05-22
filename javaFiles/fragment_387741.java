public double getAverageHorsepowerOfYear(int modelYear)
{double TotalHP = 0.0;
double avgHP = 0.0;
int count = 0

for(Lamborghini l : inventory){
    if(l.getModelYear() == modelYear){
        TotalHP = TotalHP + l.getHorsepower();
        count++;
    } 
}
avgHP = TotalHP/count;
return avgHP;
}