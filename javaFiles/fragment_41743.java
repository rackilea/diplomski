import java.util.Date;

public class VoteOption implements Comparable<VoteOption>{

    private String name;
    private Integer votes;
    private Date lastVote;

    /** Constructor */
    public VoteOption(String name){
        this.name = name;
        this.lastVote = new Date();
        this.votes = 0;
    }

    /** gets the name of this option */
    public String name(){
        return this.name;
    }

    /** gets the number of votes this option currently has */
    public int votes(){
        return this.votes;
    }

    /** Call this method if the vote passed with this option.
     * It will update the lastVote date so that this will become the
     * last option to be picked if there is a tie in the next vote. */
    public void votePassed(){
        this.lastVote = new Date();
    }

    /** resets the vote count back to 0 */
    public void resetVoteCount(){
        this.votes = 0;
    }

    /** Adds 1 vote to the vote count */
    public void vote(){
        this.votes ++;
    }

    @Override
    public int compareTo(VoteOption otherOption){
        int compareVotes = this.votes.compareTo(otherOption.votes);
        if(compareVotes!=0){
            return compareVotes;
        } else {
            //handle vote ties
            int compareDates = this.lastVote.compareTo(otherOption.lastVote);
            return compareDates;
        }
    }
}