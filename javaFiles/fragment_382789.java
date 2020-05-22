if (outputLength == output.length) {
    return output;
} else {
    byte[] truncatedOutput = new byte[outputLength];
    System.arraycopy(
            output, 0,
            truncatedOutput, 0,
            outputLength
        );
    return truncatedOutput;
}