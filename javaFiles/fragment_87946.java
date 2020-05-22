double PlanA = 0, PlanB = 0;
if (0 < daytime1 && daytime1 < 100) {
    PlanA = (((daytime1 - 100)) + (evening1 * 0.15) + (weekend1 * 0.20));
    PlanB = (((daytime1 - 250)) + (evening1 * 0.35) + (weekend1 * 0.25));
} else if (100 < daytime1 && daytime1 < 250) {
    PlanA = (((daytime1 - 100) * 0.25) + (evening1 * 0.15) + (weekend1 * 0.20));
    PlanB = (((daytime1 - 250)) + (evening1 * 0.35) + (weekend1 * 0.25));
} else if (daytime1 > 250) {
    PlanA = (((daytime1 - 100) * 0.25) + (evening1 * 0.15) + (weekend1 * 0.20));
    PlanB = (((daytime1 - 250) * 0.45) + (evening1 * 0.35) + (weekend1 * 0.25));
}