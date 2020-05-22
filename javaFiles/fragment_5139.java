import com.steadystate.css.parser.CSSOMParser
import org.htmlcleaner.CleanerProperties
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.PrettyHtmlSerializer
import org.htmlcleaner.SimpleHtmlSerializer
import org.htmlcleaner.TagNode
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.safety.Cleaner
import org.jsoup.safety.Whitelist
import org.jsoup.select.Elements
import org.w3c.css.sac.InputSource
import org.w3c.dom.css.CSSRule
import org.w3c.dom.css.CSSRuleList
import org.w3c.dom.css.CSSStyleDeclaration
import org.w3c.dom.css.CSSStyleSheet
import org.w3c.tidy.Tidy

class HtmlCleanerService {

    static transactional = true

    def cleanHTML(def html) {

        // clean with JSoup which should filter out most unwanted things and
        // ensure good html syntax
        html = soupClean(html);

        // run through JTidy to remove repeated nested tags, clean anything JSoup left out
        html = tidyClean(html);

        return html;
    }

    def tidyClean(def html) {
        Tidy tidy = new Tidy() 
        tidy.setAsciiChars(true)
        tidy.setDropEmptyParas(true)
        tidy.setDropProprietaryAttributes(true)
        tidy.setPrintBodyOnly(true)

        tidy.setEncloseText(true)
        tidy.setJoinStyles(true)
        tidy.setLogicalEmphasis(true)
        tidy.setQuoteMarks(true)
        tidy.setHideComments(true)
        tidy.setWraplen(120)

        // (makeClean || dropFontTags) = replaces presentational markup by style rules
        tidy.setMakeClean(true)     // remove presentational clutter.
        tidy.setDropFontTags(true)  

        // word2000 = drop style & class attributes and empty p, span elements
        // draconian cleaning for Word2000
        tidy.setWord2000(true)      
        tidy.setMakeBare(true)      // remove Microsoft cruft.
        tidy.setRepeatedAttributes(org.w3c.tidy.Configuration.KEEP_FIRST) // keep first or last duplicate attribute

        // TODO ? tidy.setForceOutput(true)

        def reader = new StringReader(html);
        def writer = new StringWriter();

        // hide output from stderr
        tidy.setShowWarnings(false)
        tidy.setErrout(new PrintWriter(new StringWriter()))

        tidy.parse(reader, writer); // run tidy, providing an input and output stream
        return writer.toString()
    }

    def soupClean(def html) {

        // clean the html
        Document dirty = Jsoup.parseBodyFragment(html);
        Cleaner cleaner = new Cleaner(createWhitelist());
        Document clean = cleaner.clean(dirty);

        // now hunt down all style attributes and ensure we only have those that render with iTextPDF
        Elements styledNodes = clean.select("[style]"); // a with href
        styledNodes.each { element ->
            def style = element.attr("style");
            def tag = element.tagName().toLowerCase()
            def newstyle = ""
            CSSOMParser parser = new CSSOMParser();
            InputSource is = new InputSource(new StringReader(style))
            CSSStyleDeclaration styledeclaration = parser.parseStyleDeclaration(is)
            boolean hasProps = false
            for (int i=0; i < styledeclaration.getLength(); i++) {
                def propname = styledeclaration.item(i)
                def propval = styledeclaration.getPropertyValue(propname)
                propval = propval ? propval.trim() : ""

                if (["padding-left", "text-decoration", "text-align", "font-weight", "font-style"].contains(propname)) {
                    newstyle = newstyle + propname + ": " + propval + ";"
                    hasProps = true
                }

                // standardize table widths, itextPDF won't render tables if there is only width in the
                // style attribute.  Here we ensure the width is in its own attribute, and change the value so
                // it is in percentage and no larger than 100% to avoid end users from creating really goofy
                // tables that they can't edit properly becuase they have made the width too large.
                //
                // width of the display area in the editor is about 740px, so let's ensure everything
                // is relative to that
                //
                // TODO could get into trouble with nested tables and widths within as we assume
                // one table (e.g. could have nested tables both with widths of 500)
                if (tag.equals("table") && propname.equals("width")) {
                    if (propval.endsWith("%")) {
                        // ensure it is <= 100%
                        propval = propval.replaceAll(~"[^0-9]", "")
                        propval = Math.min(100, propval.toInteger())
                    }
                    else {
                        // else we have measurement in px or assumed px, clean up and
                        // get integer value, then calculate a percentage
                        propval = propval.replaceAll(~"[^0-9]", "")
                        propval = Math.min(100, (int) (propval.toInteger() / 740)*100)
                    } 
                    element.attr("width", propval + "%")
                }
            }
            if (hasProps) {
                element.attr("style", newstyle)
            } else {
                element.removeAttr("style")
            }

        }

        return clean.body().html();
    }

    /**
     * Returns a JSoup whitelist suitable for sane HTML output and iTextPDF 
     */
    def createWhitelist() {
        Whitelist wl = new Whitelist();

        // iText supported tags
        wl.addTags(
            "br", "div", "p", "pre", "span", "blockquote", "q", "hr",
            "h1", "h2", "h3", "h4", "h5", "h6",
            "u", "strike", "s", "strong", "sub", "sup", "em", "i", "b", 
            "ul", "ol", "li", "ol",
            "table", "tbody", "td", "tfoot", "th", "thead", "tr", 
            );

        // iText attributes recognized which we care about
        // padding-left (div/p/span indentation)
        // text-align (for table right/left align)
        // text-decoration (for span/div/p underline, strikethrough)
        // font-weight (for span/div/p bolder etc)
        // font-style (for span/div/p italic etc)
        // width (for tables)
        // colspan/rowspan (for tables)

        ["span", "div", "p", "table", "ul", "ol", "pre", "td", "th"].each { tag ->
            ["style", "padding-left", "text-decoration", "text-align", "font-weight", "font-style"].each { attr ->
                wl.addAttributes(tag, attr)
            }
        }

        ["td", "th"].each { tag ->
            ["colspan", "rowspan", "width"].each { attr ->
                wl.addAttributes(tag, attr)
            }
        }
        wl.addAttributes("table", "width", "style", "cellpadding")

        // img support
        // wl.addAttributes("img", "align", "alt", "height", "src", "title", "width")


        return wl
    }
}