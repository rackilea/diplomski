public SegmentConstructor(int seqNum_, int length_) {
    this(seqNum_, length_, false); // calls the constructor below.
}

public SegmentConstructor(int seqNum_, int length_, boolean required_) {
    seqNum = seqNum_;
    length = length_;
    required = required_;
}