File stats = new File(statFile);
Boolean fromStart = stats.createNewFile();

// my code here.... the stat values change here.  

FileWriter statFileWriter = new FileWriter(stats, true);
BufferedWriter statsOutput = new BufferedWriter(statFileWriter);
if(fromStart == false) statsOutput.write("\n");
statsOutput.write(Stats.printStat());
statsOutput.flush();