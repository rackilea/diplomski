while ((line = br.readLine()) != null)
{

    stateCode[i] = Integer.parseInt(line.substring(0, 1));
    population[i] = Integer.parseInt(line.substring(82, 89));
    childPopulation[i] = Integer.parseInt(line.substring(91, 98));
    i++;        
}
br.close();