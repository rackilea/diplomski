float totalVirtualRealTime_ms=0;
float speedAdjustments_ms=0; // to introduce a virtual Time for the animation (reduce or increase animation speed)
float totalAnimationTime_ms=0;
float fixedStepAnimation_ms=20; // 20ms for a 50FPS descriptive animation
int currVirtualAnimationFrame=0; // useful if the updateGameFixedStep routine ask for a frame number

private void updateGame(){
    totalVirtualRealTime_ms+=smoothedDeltaRealTime_ms + speedAdjustments_ms;

    while (totalVirtualRealTime_ms> totalAnimationTime_ms){
        totalAnimationTime_ms+=fixedStepAnimation_ms;
        currVirtualAnimationFrame++;
        // original updateGame with fixed step                
        updateGameFixedStep(currVirtualAnimationFrame);
    }


    float interpolationRatio=(totalAnimationTime_ms-totalVirtualRealTime_ms)/fixedStepAnimation_ms;
    Interpolation(interpolationRatio);
}