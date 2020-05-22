FrameBuffer frameBuffer = new FrameBuffer(Pixmap.Format.RGBA8888, bufferSize, bufferSize, false) {
        @Override
        protected Texture createColorTexture() {
            PixmapTextureData data = new PixmapTextureData(new Pixmap(width, height, format), format, false, false);
            Texture result = new Texture(data);
            result.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            result.setWrap(Texture.TextureWrap.ClampToEdge, Texture.TextureWrap.ClampToEdge);
            return result;
        }
    };