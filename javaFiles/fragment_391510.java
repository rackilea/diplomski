default IntermediateStreamTransform chain(IntermediateStreamTransform nextTransformer)
    throws IOException {
    Objects.requireNonNull(nextTransformer);

    return is -> {
        InputStream intermediateStream = this.intermediateTransform(is);
        return nextTransformer.intermediateTransform(intermediateStream);
    };
}

default <T> StreamTransformResult<T> finalize(InputStream is, 
    StreamTransformer<T> streamTransformer) throws IOException {
    Objects.requireNonNull(streamTransformer);

    return () -> {
        InputStream intermediateStream = this.intermediateTransform(is);
        StreamTransformResult<T> streamTransformResult = streamTransformer.transform(
            intermediateStream
        );
        return streamTransformResult.getResult();
    };
}