import edu.berkeley.nlp.mt.Alignment;
import edu.berkeley.nlp.mt.SentencePair;
import edu.berkeley.nlp.wordAlignment.PosteriorAligner;
import edu.berkeley.nlp.wordAlignment.WordAligner;
import fig.basic.Fmt;
import fig.basic.ListUtils;
import java.util.ArrayList;
import java.util.List;

public abstract  class CombinedAligner extends PosteriorAligner {

    private static final long serialVersionUID = 1;
    WordAligner wa1;
    WordAligner wa2;

    public CombinedAligner (WordAligner, WordAligner)
    public String getName()
    public Alignment alignSentencePair(SentencePair)
    public List alignSentencePairReturnAll(SentencePair)
    public void setThreshold(int)
    abstract Alignment combineAlignments(Alignment, Alignment, SentencePair)

}