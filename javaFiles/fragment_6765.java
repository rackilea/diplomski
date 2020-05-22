ResourceA resourceA = getResourceA(); 
ResourceB resourceB = getResourceB();

CostContainer costContainer = new CostContainer();

CostCalculator aCostCalculator = new ACostCalculator();
CostCalculator bCostCalculator = new BCostCalculator();
CostCalculator cCostCalculator = new CCostCalculator(resourceA);
CostCalculator dCostCalculator = new DCostCalculator(resourceA);
CostCalculator eCostCalculator = new ECostCalculator(resourceA, resourceB);

aCostCalculator.calculate(costContainer);
bCostCalculator.calculate(costContainer);
cCostCalculator.calculate(costContainer);
dCostCalculator.calculate(costContainer);
eCostCalculator.calculate(costContainer);