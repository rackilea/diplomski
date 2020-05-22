ImageUtil.flipImageVertically(imageBuff[i]);
            {
                TextureData textureData = AWTTextureIO.newTextureData(gl3.getGLProfile(), textureBuffIm,
                        mipmap);

                gl3.glBindTexture(GL3.GL_TEXTURE_2D, objects[Objects.texture.ordinal()]);
                {
                    int[] alignment = new int[1];
                    gl3.glGetIntegerv(GL3.GL_UNPACK_ALIGNMENT, alignment, 0);
//                System.out.println("alignment[0] "+alignment[0]);
//                System.out.println("textureData.getAlignment() "+textureData.getAlignment());
                    if (alignment[0] != textureData.getAlignment()) {

                        gl3.glPixelStorei(GL3.GL_UNPACK_ALIGNMENT, textureData.getAlignment());
                    }
                    {
                        gl3.glTexImage2D(GL3.GL_TEXTURE_2D, 0, textureData.getInternalFormat(), textureData.getWidth(),
                                textureData.getHeight(), textureData.getBorder(), textureData.getPixelFormat(),
                                textureData.getPixelType(), textureData.getBuffer());
                    }
                    if (alignment[0] != textureData.getAlignment()) {

                        gl3.glPixelStorei(GL3.GL_UNPACK_ALIGNMENT, alignment[0]);
                    }