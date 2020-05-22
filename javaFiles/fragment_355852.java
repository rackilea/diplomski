int teams = 3;
int teamSize = 2;
if (arr.length >= teams * teamSize) // check if array contains enough IDs
{
    for (int i = 0; (i < arr.length) && (i < teams * teamSize); i += teamSize) {
        System.out.println("Team: " + i/teamSize+1); // print team number
        for (int j = 0; j < teamSize; j++)           // get all team members
        {
            System.out.println(arr[i+j]);            // print ID of team member of team
        }
    }
}