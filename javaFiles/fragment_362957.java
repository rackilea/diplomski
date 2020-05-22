/**
 * Tokenizers can also be chained.
 * 
 * `chilperic ii son of childeric ii`
 * 
 * By splitting on whitespace is tokenized into:
 * 
 * `[chilperic, ii, son, of, childeric, ii]`
 * 
 * After using a q-gram with a q of 2:
 * 
 * `[ch,hi,il,il,lp,pe,er,ri,ic, ii, so,on, of, ch,hi,il,ld,de,er,ri,ic,
 * ii]`
 * 
 */
public static float example04() {

    String a = "A quirky thing it is. This is a sentence.";
    String b = "This sentence is similar; a quirky thing it is.";

    StringMetric metric = 
            with(new CosineSimilarity<String>())
            .tokenize(Tokenizers.whitespace())
            .tokenize(Tokenizers.qGram(3))
            .build();

    return metric.compare(a, b); // 0.8292
}