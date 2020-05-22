CpuPlayer cpu;

if (difficulty == 0){
    cpu = new EasyPlayer(num_rounds);
}
else{
    cpu = new HardPlayer(num_rounds);
}