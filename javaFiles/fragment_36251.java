int w = 479;
int h = 616;

byte[] file = /* as before */;

// Convert interleaved byte RGB to packed int ARGB
int[] paddedFile = new int[file.length / 3];
for (int i = 0; i < file.length / 3; i++) {
    paddedFile[i] = 0xff << 24 // Alpha (all opaque)
                  | ((file[i * 3] & 0xff) << 16) 
                  | ((file[i * 3 + 1] & 0xff) << 8) 
                  | ((file[i * 3 + 2] & 0xff)) 
}

int stride = w + (w % 4 == 0 ? 0 : 4 - (w % 4));
Bitmap screen = Bitmap.createBitmap(paddedFile, 0, stride, w, h, Bitmap.Config.ARGB_8888);