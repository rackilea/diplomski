*clojure-version*
{:major 1, :minor 3, :incremental 0, :qualifier nil}
user> (import 'java.awt.image.BufferedImageOp)
java.awt.image.BufferedImageOp
user> (import 'java.awt.image.BufferedImage)
java.awt.image.BufferedImage
user> (Scalr/resize (BufferedImage. 10 10 BufferedImage/TYPE_INT_ARGB) 200 (into-array BufferedImageOp []))
#<BufferedImage BufferedImage@ccfe446: type = 2 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=ff000000 IntegerInterleavedRaster: width = 200 height = 200 #Bands = 4 xOff = 0 yOff = 0 dataOffset[0] 0>
user>