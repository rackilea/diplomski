@Entity
@Table(name ="VIEW_TWO")
private CpBracketSummaryData(){

}


@Entity
@Table(name = "ONE")
public class CpBracket {

    @OneToOne
    @PrimaryKeyJoinColumn
    private CPBracketSummaryData summaryData;

    public int getSomeValue(){
        return summaryData.getSomeValue();
    }
}