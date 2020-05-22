IRational fps = IRational.make(24, 1);
outStreamCoder.setFrameRate(fps);
outStreamCoder.setTimeBase(IRational.make(fps.getDenominator(),  fps.getNumerator()));

...

long timeStamp = (1e6/fps.getNumerator() * count);