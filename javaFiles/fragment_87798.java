gl4.glGenTextures(1, indexBuffer);
        int textureIndex = indexBuffer.get();
        indexBuffer.clear();

        gl4.glBindTexture(GL4.GL_TEXTURE_2D, textureIndex);
        gl4.glTexParameterf(GL4.GL_TEXTURE_2D, GL4.GL_TEXTURE_MIN_FILTER, GL4.GL_LINEAR);
        gl4.glTexParameterf(GL4.GL_TEXTURE_2D, GL4.GL_TEXTURE_MAG_FILTER, GL4.GL_LINEAR);
        gl4.glTexImage2D(GL4.GL_TEXTURE_2D, 0, GL4.GL_RGBA32F, width, height, 0, GL4.GL_RGBA, GL4.GL_FLOAT, pixelBuffer); //TODO

        gl4.glTexParameteri(GL4.GL_TEXTURE_2D, GL4.GL_TEXTURE_BASE_LEVEL, 0);
        gl4.glTexParameteri(GL4.GL_TEXTURE_2D, GL4.GL_TEXTURE_MAX_LEVEL, 0);

        int[] swizzle = new int[] { GL4.GL_RED, GL4.GL_GREEN, GL4.GL_BLUE, GL4.GL_ONE };
        gl4.glTexParameterIiv(GL4.GL_TEXTURE_2D, GL4.GL_TEXTURE_SWIZZLE_RGBA, swizzle, 0);
        gl4.glBindTexture(GL4.GL_TEXTURE_2D, 0);
        return textureIndex;