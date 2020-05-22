stream.saveGraphicsState();
PDExtendedGraphicsState pdExtGfxState = new PDExtendedGraphicsState();
pdExtGfxState.getCOSObject().setItem(COSName.BM, COSName.MULTIPLY); // pdExtGfxState.setBlendMode(BlendMode.MULTIPLY) doesn't work yet, maybe in later version 
pdExtGfxState.setNonStrokingAlphaConstant(0.5f);
contentStream.setGraphicsStateParameters(pdExtGfxState);
// do your stuff
stream.restoreGraphicsState();