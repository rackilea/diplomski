String uri = "path_to_svg/some.svg";

MyTranscoder transcoder = new MyTranscoder();
TranscodingHints hints = new TranscodingHints();
hints.put(ImageTranscoder.KEY_WIDTH, 20f); //your image width
hints.put(ImageTranscoder.KEY_HEIGHT, 20f); //your image height
hints.put(ImageTranscoder.KEY_DOM_IMPLEMENTATION,    SVGDOMImplementation.getDOMImplementation());
hints.put(ImageTranscoder.KEY_DOCUMENT_ELEMENT_NAMESPACE_URI, SVGConstants.SVG_NAMESPACE_URI);
hints.put(ImageTranscoder.KEY_DOCUMENT_ELEMENT, SVGConstants.SVG_SVG_TAG);
hints.put(ImageTranscoder.KEY_XML_PARSER_VALIDATING, false);

transcoder.setTranscodingHints(hints);
TranscoderInput input = new TranscoderInput(url.toExternalForm());
transcoder.transcode(input, null);
BufferedImage bufferedImage = transcoder.getImage();