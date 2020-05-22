import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;

public class HtmlToExcel {

    private static final int START_TAG = 0;
    private static final int END_TAG = 1;
    private static final char BULLET_CHARACTER = '\u2022';
    private static final String NEW_LINE = System.getProperty("line.separator");

    public static void main(String[] args) {
        String html = "<ul>"
                + "<li><em><strong>Bold Non-Colored + <span style=\"color: #FF0000\">Bolded and Colored Text</span></strong> </em> + Non font trailing<br/></li>"
                + "<li>No Styling...Just a Text</li>"
                + "<li><u><b>Bolded </b> and <i>Italic </i> and Underlined Text</u></li>"
                + "<li><u>Underline Started and <span style=\"color: #00FF00\">Only Colored Text</span> Underline Ended</u></li>"
                + "</ul>";

        HSSFWorkbook workBook = new HSSFWorkbook();
        HSSFSheet sheet = workBook.createSheet("Html Text");

        Source source = new Source(html);
        int cellNo = 0;
        for (Element ul : source.getAllElements("ul")) {
            List<RichTextDetails> cellValues = new ArrayList<HtmlToExcel.RichTextDetails>();
            for (Element li : ul.getAllElements("li")) {
                cellValues.add(createCellValue(li.toString(), workBook));
            }
            createCell(cellValues, workBook, sheet, cellNo++);
        }

        FileOutputStream out = null;
        try {
            out = new FileOutputStream(new File("C:\\new.xls"));
            workBook.write(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Done");
    }

    private static void createCell(List<RichTextDetails> cellValues,
            HSSFWorkbook workBook, HSSFSheet sheet, int cellNo) {
        HSSFRichTextString cellValue = mergeTextDetails(cellValues);
        HSSFCellStyle wrapStyle = workBook.createCellStyle();
        wrapStyle.setWrapText(true);
        Row row = sheet.createRow(cellNo);
        Cell cell = row.createCell(0);
        cell.setCellValue(cellValue);
    }

    private static HSSFRichTextString mergeTextDetails(
            List<RichTextDetails> cellValues) {
        StringBuilder textBuffer = new StringBuilder();
        Map<Integer, HSSFFont> mergedMap = new LinkedHashMap<Integer, HSSFFont>();
        int currentIndex = 0;
        for(RichTextDetails richTextDetail : cellValues){
            textBuffer.append(BULLET_CHARACTER + " ");
            currentIndex = textBuffer.length();
            for (Entry<Integer, HSSFFont> entry : richTextDetail.getFontMap().entrySet()) {
            mergedMap.put(entry.getKey() + currentIndex, entry.getValue());
        }
            textBuffer.append(richTextDetail.getRichText()).append(NEW_LINE);
        }

        HSSFRichTextString richText = new HSSFRichTextString(textBuffer.toString());
    for (int i = 0; i < textBuffer.length(); i++) {
        HSSFFont currentFont = mergedMap.get(i);
        if (currentFont != null) {
        richText.applyFont(i, i + 1, currentFont);
        }
    }
        return richText;
    }

    private static RichTextDetails createCellValue(String html, HSSFWorkbook workBook) {
        Source source = new Source(html);
        Map<String, TagInfo> tagMap = new LinkedHashMap<String, HtmlToExcel.TagInfo>();
        for (Element e : source.getChildElements()) {
            getInfo(e, tagMap);
        }

        String patternString = "(" + StringUtils.join(tagMap.keySet(), "|") + ")";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(html);

        StringBuffer textBuffer = new StringBuffer();
        List<RichTextInfo> textInfos = new ArrayList<HtmlToExcel.RichTextInfo>();
        Stack<RichTextInfo> richTextBuffer = new Stack<HtmlToExcel.RichTextInfo>();
        while (matcher.find()) {
            matcher.appendReplacement(textBuffer, "");
            TagInfo currentTag = tagMap.get(matcher.group(1));
            if (START_TAG == currentTag.getTagType()) {
                richTextBuffer.push(getRichTextInfo(currentTag, textBuffer.length(), workBook));
            } else {
                if (!richTextBuffer.isEmpty()) {
                    RichTextInfo info = richTextBuffer.pop();
                    if (info != null) {
                        info.setEndIndex(textBuffer.length());
                        textInfos.add(info);
                    }
                }
            }
        }
        matcher.appendTail(textBuffer);
        Map<Integer, HSSFFont> fontMap = buildFontMap(textInfos, workBook);

        return new RichTextDetails(textBuffer.toString(), fontMap);
    }

    private static Map<Integer, HSSFFont> buildFontMap(
            List<RichTextInfo> textInfos, HSSFWorkbook workBook) {
        Map<Integer, HSSFFont> fontMap = new LinkedHashMap<Integer, HSSFFont>();

        for (RichTextInfo richTextInfo : textInfos) {
            if (richTextInfo.isValid()) {
                for (int i = richTextInfo.getStartIndex(); i < richTextInfo.getEndIndex(); i++) {
                    fontMap.put(i, mergeFont(fontMap.get(i), richTextInfo.getFontStyle(), richTextInfo.getFontValue(), workBook));
                }
            }
        }

        return fontMap;
    }

    private static HSSFFont mergeFont(HSSFFont font, STYLES fontStyle,
            String fontValue, HSSFWorkbook workBook) {
        if (font == null) {
            font = workBook.createFont();
        }

        switch (fontStyle) {
            case BOLD:
            case EM:
            case STRONG:
                font.setBoldweight(Font.BOLDWEIGHT_BOLD);
                break;
            case UNDERLINE:
                font.setUnderline(HSSFFont.U_SINGLE);
                break;
            case ITALLICS:
                font.setItalic(true);
                break;
            case COLOR:
                if (!isEmpty(fontValue)) {
                    HSSFPalette palette = workBook.getCustomPalette();
                    HSSFColor myColor = palette.findSimilarColor(
                            Integer.valueOf(fontValue.substring(2, 4), 16),
                            Integer.valueOf(fontValue.substring(4, 6), 16),
                            Integer.valueOf(fontValue.substring(6, 8), 16));
                    font.setColor(myColor.getIndex());
                }
                break;
            default:
                break;
        }

        return font;
    }

    private static RichTextInfo getRichTextInfo(TagInfo currentTag,
            int startIndex, HSSFWorkbook workBook) {
        RichTextInfo info = null;
        switch (STYLES.fromValue(currentTag.getTagName())) {
            case SPAN:
                if (!isEmpty(currentTag.getStyle())) {
                    for (String style : currentTag.getStyle().split(";")) {
                        String[] styleDetails = style.split(":");
                        if (styleDetails != null && styleDetails.length > 1) {
                            if ("COLOR".equalsIgnoreCase(styleDetails[0].trim())) {
                                info = new RichTextInfo(startIndex, -1, STYLES.COLOR, styleDetails[1]);
                            }
                        }
                    }
                }
                break;
            default:
                info = new RichTextInfo(startIndex, -1, STYLES.fromValue(currentTag.getTagName()));
                break;
        }
        return info;
    }

    private static boolean isEmpty(String str) {
        return (str == null || str.trim().length() == 0);
    }

    private static void getInfo(Element e, Map<String, HtmlToExcel.TagInfo> tagMap) {
        tagMap.put(e.getStartTag().toString(), new TagInfo(e.getStartTag().getName(), e.getAttributeValue("style"), START_TAG));
        if (e.getChildElements().size() > 0) {
            List<Element> children = e.getChildElements();
            for (Element child : children){
                getInfo(child, tagMap);
            }
        }
        if (e.getEndTag() != null) {
            tagMap.put(e.getEndTag().toString(), new TagInfo(e.getEndTag().getName(), END_TAG));
        } else {
            // Handling self closing tags
            tagMap.put(e.getStartTag().toString(), new TagInfo(e.getStartTag().getName(), END_TAG));
        }
    }

    static class RichTextInfo {
        private int startIndex;
        private int endIndex;
        private STYLES fontStyle;
        private String fontValue;

        public RichTextInfo(int startIndex, int endIndex, STYLES fontStyle) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.fontStyle = fontStyle;
        }

        public RichTextInfo(int startIndex, int endIndex, STYLES fontStyle,
                String fontValue) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.fontStyle = fontStyle;
            this.fontValue = fontValue;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        public int getEndIndex() {
            return endIndex;
        }

        public void setEndIndex(int endIndex) {
            this.endIndex = endIndex;
        }

        public STYLES getFontStyle() {
            return fontStyle;
        }

        public void setFontStyle(STYLES fontStyle) {
            this.fontStyle = fontStyle;
        }

        public String getFontValue() {
            return fontValue;
        }

        public void setFontValue(String fontValue) {
            this.fontValue = fontValue;
        }

        public boolean isValid() {
            return (startIndex != -1 && endIndex != -1 && endIndex >= startIndex);
        }

        @Override
        public String toString() {
            return "RichTextInfo [startIndex=" + startIndex + ", endIndex="
                    + endIndex + ", fontStyle=" + fontStyle + ", fontValue="
                    + fontValue + "]";
        }
    }

    static class RichTextDetails {
        private String richText;
        private Map<Integer, HSSFFont> fontMap;

        public RichTextDetails(String richText,
                Map<Integer, HSSFFont> fontMap) {
            this.richText = richText;
            this.fontMap = fontMap;
        }

        public String getRichText() {
            return richText;
        }
        public void setRichText(String richText) {
            this.richText = richText;
        }
        public Map<Integer, HSSFFont> getFontMap() {
            return fontMap;
        }
        public void setFontMap(Map<Integer, HSSFFont> fontMap) {
            this.fontMap = fontMap;
        }
    }

    static class TagInfo {
        private String tagName;
        private String style;
        private int tagType;

        public TagInfo(String tagName, String style, int tagType) {
            this.tagName = tagName;
            this.style = style;
            this.tagType = tagType;
        }

        public TagInfo(String tagName, int tagType) {
            this.tagName = tagName;
            this.tagType = tagType;
        }

        public String getTagName() {
            return tagName;
        }

        public void setTagName(String tagName) {
            this.tagName = tagName;
        }

        public int getTagType() {
            return tagType;
        }

        public void setTagType(int tagType) {
            this.tagType = tagType;
        }

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        @Override
        public String toString() {
            return "TagInfo [tagName=" + tagName + ", style=" + style
                    + ", tagType=" + tagType + "]";
        }
    }

    enum STYLES {
        BOLD("b"), 
        EM("em"), 
        STRONG("strong"), 
        COLOR("color"), 
        UNDERLINE("u"), 
        SPAN("span"), 
        ITALLICS("i"), 
        UNKNOWN("unknown");

        private String type;

        private STYLES(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public static STYLES fromValue(String type) {
            for (STYLES style : values()) {
                if (style.type.equalsIgnoreCase(type)) {
                    return style;
                }
            }
            return UNKNOWN;
        }
    }
}