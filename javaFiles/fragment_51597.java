int textureCount = 4;
TextureRegion[] mTextureRegions = new TextureRegion[textureCount];

for (int i = 0; i < mTextureRegions.length; i++)
   this.mTextureRegions[i] = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mTextureAtlas, this, "p" + (i + 1) + ".png", i * 130, 0);
this.mTextureAtlas.load();