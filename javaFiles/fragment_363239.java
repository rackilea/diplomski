this.teams = new Team[noOfTeams];

for (int i = 0; i < noOfTeams; i++) 
{     
    this.teams[i] = new Team();   
    this.teams[i].setId(i);
    this.teams[i].setRank(i);       
    queue.add(this.teams[i]);
}