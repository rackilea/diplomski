public class TokenGroup {

    ...

    protected boolean isDistinct() {
        return offsetAtt.startOffset() >= endOffset;
    }

    ...