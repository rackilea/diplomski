// Instance based (inside classes)
{SCOPE MODIFIER} void ClockWork()
{
    clockStateIndex = clockSource.nextClearBit(clockStateIndex);    
    clockStateIndex = clockSource.nextSetBit(clockStateIndex);
    testIndex = (clockSource.nextClearBit(clockStateIndex) - clockStateIndex) / 2;  
}