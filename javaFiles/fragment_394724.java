public class AMANwsClient  extends AbstractTransformer{

@Override
protected Object doTransform(Object src, String enc)
        throws TransformerException {
     AMANSequence sequence = new AMANSequence();


    XMLGregorianCalendar fec;
    sequence.setSequenceGenerationTime(fec);
    sequence.setAMANId("AA");
    System.out.println(sequence);
    return sequence;
}