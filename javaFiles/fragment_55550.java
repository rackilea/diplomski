vector<double>::iterator it;
{
    vector<double> result = processSimulation(Q);
    it = result.begin();
}
double mean = *it;    // boom