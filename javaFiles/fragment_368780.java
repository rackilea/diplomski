public Bitmap ColorDodgeBlend(Bitmap source, Bitmap layer) {
            Bitmap base = source.copy(Config.ARGB_8888, true);
            Bitmap blend = layer.copy(Config.ARGB_8888, false);

            IntBuffer buffBase = IntBuffer.allocate(base.getWidth() * base.getHeight());
            base.copyPixelsToBuffer(buffBase);
            buffBase.rewind();

            IntBuffer buffBlend = IntBuffer.allocate(blend.getWidth() * blend.getHeight());
            blend.copyPixelsToBuffer(buffBlend);
            buffBlend.rewind();

            IntBuffer buffOut = IntBuffer.allocate(base.getWidth() * base.getHeight());
            buffOut.rewind();

            while (buffOut.position() < buffOut.limit()) {

                int filterInt = buffBlend.get();
                int srcInt = buffBase.get();

                int redValueFilter = Color.red(filterInt);
                int greenValueFilter = Color.green(filterInt);
                int blueValueFilter = Color.blue(filterInt);

                int redValueSrc = Color.red(srcInt);
                int greenValueSrc = Color.green(srcInt);
                int blueValueSrc = Color.blue(srcInt);

                int redValueFinal = colordodge(redValueFilter, redValueSrc);
                int greenValueFinal = colordodge(greenValueFilter, greenValueSrc);
                int blueValueFinal = colordodge(blueValueFilter, blueValueSrc);


                int pixel = Color.argb(255, redValueFinal, greenValueFinal, blueValueFinal);


                buffOut.put(pixel);
            }

            buffOut.rewind();

            base.copyPixelsFromBuffer(buffOut);
            blend.recycle();

            return base;
        }