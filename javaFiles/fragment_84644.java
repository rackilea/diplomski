public void replace(IFrame iFrame) {
    if (iFrame instanceof Frame) {
        Frame f = (Frame) iFrame;
        if (f.numRows < this.numRows) {
            // Do what you want to do if the provided frame has fewer rows than this frame
            return; // Return in the if condition, this way you do not proceed to the for loop causing an IndexOutOfBounds exception
        }
        for (int i=0; i<numRows; i++){
            for (int o=0; o<numRows; o++){
                   (Frame f).code[i][o] = this.code[i][o];
                }
            }
        }
    }
}