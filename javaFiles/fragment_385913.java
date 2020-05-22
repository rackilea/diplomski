class CustomizedScoreProvider extends CustomScoreProvider {
private LeafReaderContext context;
public CustomizedScoreProvider(LeafReaderContext reader) {
        super(reader);
        this.context= reader;
        // TODO Auto-generated constructor stub
    }

public  float customScore(int doc, float subQueryScore,float valSrcScores[]) throws IOException{

    Document Social=context.reader().document(doc);
     IndexableField i= Social.getField("soc");// the field I wanted to extract
     float k= (float)i.numericValue();
     subQueryScore+=k;

return subQueryScore;
         }
}