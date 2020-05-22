import com.coremedia.blueprint.cae.richtext.filter.FilterFactory;
import com.coremedia.xml.Filter;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GlossaryFilter extends Filter implements FilterFactory {
  private static final String SPAN = "span";
  private static final String CLASS = "class";

  private boolean isAbbreviation = false;
  private boolean isExplanation = false;
  private String abbreviation;
  private String currentUri;
  private boolean spanExplanationClose = false;
  private boolean spanAbbreviationClose = false;

  @Override
  public Filter getInstance(final HttpServletRequest request, final HttpServletResponse response) {
    return new GlossaryFilter();
  }

  @Override
  public void startElement(final String uri, final String localName, final String qName,
      final Attributes attributes) throws SAXException {
    if (isSpanAbbreviationTag(qName, attributes)) {
      isAbbreviation = true;
    } else if (isSpanExplanationTag(qName, attributes)) {
      isExplanation = true;
      currentUri = uri;
    } else {
      super.startElement(uri, localName, qName, attributes);
    }
  }

  private boolean isSpanExplanationTag(final String qName, final Attributes attributes) {
    //noinspection OverlyComplexBooleanExpression
    return StringUtils.isNotEmpty(qName) && qName.equalsIgnoreCase(SPAN) && (
        attributes.getLength() > 0) && attributes.getValue(CLASS).equals("explanation");
  }

  private boolean isSpanAbbreviationTag(final String qName, final Attributes attributes) {
    //noinspection OverlyComplexBooleanExpression
    return StringUtils.isNotEmpty(qName) && qName.equalsIgnoreCase(SPAN) && (
        attributes.getLength() > 0) && attributes.getValue(CLASS).equals("abbreviation");
  }

  @Override
  public void endElement(final String uri, final String localName, final String qName)
      throws SAXException {
    if (spanExplanationClose) {
      spanExplanationClose = false;
    } else if (spanAbbreviationClose) {
      spanAbbreviationClose = false;
    } else {
      super.endElement(uri, localName, qName);
    }
  }

  @Override
  public void characters(final char[] ch, final int start, final int length) throws SAXException {
    if (isAbbreviation && isExplanation) {
      final String explanation = new String(ch, start, length);
      final AttributesImpl newAttributes = createAttributes(explanation);
      writeAbbrTag(newAttributes);
      changeState();
    } else if (isAbbreviation && !isExplanation) {
      abbreviation = new String(ch, start, length);
    } else {
      super.characters(ch, start, length);
    }
  }

  private void changeState() {
    isExplanation = false;
    isAbbreviation = false;
    spanExplanationClose = true;
    spanAbbreviationClose = true;
  }

  @SuppressWarnings("TypeMayBeWeakened")
  private void writeAbbrTag(final AttributesImpl newAttributes) throws SAXException {
    super.startElement(currentUri, "abbr", "abbr", newAttributes);
    super.characters(abbreviation.toCharArray(), 0, abbreviation.length());
    super.endElement(currentUri, "abbr", "abbr");
  }

  private AttributesImpl createAttributes(final String explanation) {
    final AttributesImpl newAttributes = new AttributesImpl();
    newAttributes.addAttribute(currentUri, "title", "abbr:title", "CDATA", explanation);
    return newAttributes;
  }
}