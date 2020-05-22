this.mTextureAtlas = new BitmapTextureAtlas(this.getTextureManager(), 4 * 130, 130);
            this.m1TextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mTextureAtlas, this, "p1.png", 0, 0);
            this.m2TextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mTextureAtlas, this, "p2.png", 130, 0);
            this.m3TextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mTextureAtlas, this, "p3.png", 260, 0);
            this.m4TextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mTextureAtlas, this, "p4.png", 390, 0);
            this.mTextureAtlas.load();