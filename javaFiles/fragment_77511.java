import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.XsltCompiler;

Processor processor = new Processor(configuration);
processor.setConfigurationProperty(FeatureKeys.SUPPRESS_XSLT_NAMESPACE_CHECK, "true");
XsltCompiler xsltCompiler = processor.newXsltCompiler();