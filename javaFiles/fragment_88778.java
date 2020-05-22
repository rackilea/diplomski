public class Rating { 

public int votes;
public double score;
public String result;


public Rating() {
    votes = 0;
    score = 0;
}

public void resetVotes(){
    this.votes = 0;
    this.score = 0;
}

public int getNumVotes(){
    return this.votes;
}

public void addVote(double rating){
    this.votes = this.votes + 1;
    this.score = this.score + rating;
}

public double computeScore() {
    return (this.score / this.votes);
}

@Override
public String toString() {
  String result;
  double score = computeScore();
  if (this.votes > 1)
  {
    if (score <= 0)
        result = "";
    else if (score <= 1)
        result = "*";
    else if (score <= 2)
        result = "**";
    else if (score <= 3)
        result = "***";
    else
        result =  "****";
   }
   else
        result = "No votes.";

   return result;
 }
}