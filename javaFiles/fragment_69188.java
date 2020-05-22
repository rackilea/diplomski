fun Path.readImage(): BufferedImage =
    ImageIcon(toUri().toURL()).let {
        BufferedImage(it.iconWidth, it.iconHeight, BufferedImage.TYPE_INT_ARGB).apply {
            it.paintIcon(null, createGraphics(), 0, 0)
        }
    }