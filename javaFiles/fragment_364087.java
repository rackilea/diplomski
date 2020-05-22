boolean [] trshIt;
double [] CO2TrashEmissions = {184.0, 25.6, 46.6, 165.8};

//constructor
CO2FromWaste(int crust, boolean p, boolean pl, boolean gl, boolean ca)
{
    myPlot = 1018.0;
    myCrust = crust;
    myP = p;
    myPl = pl;
    myGl = gl;
    myCa = ca;

    trshIt = new boolean[4];
    trshIt[0] = myP;
    trshIt[1] = myPla;
    trshIt[2] = myGl;
    trshIt[3] = myCa;
}