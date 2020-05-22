@XmlRootElement(name = "myImageCapList")
    class ImageCapList {
        @XmlElement
        List<ImageCap> imageCap;

        public ImageCapList() {}

        public ImageCapList(List<ImageCap> imageCaps) {
            this.imageCap = imageCaps;
        }
    }