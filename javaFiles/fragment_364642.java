public string GetHtml()
{
    var html = new StringBuilder();
    var repeatCount = 15;
    for (int i = 0; i < repeatCount; ++i) { html.Append("<h1>h1</h1>"); }

    var text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vestibulum sollicitudin luctus. Curabitur at eros bibendum, porta risus a, luctus justo. Phasellus in libero vulputate, fermentum ante nec, mattis magna. Nunc viverra viverra sem, et pulvinar urna accumsan in. Quisque ultrices commodo mauris, et convallis magna. Duis consectetur nisi non ultrices dignissim. Aenean imperdiet consequat magna, ac ornare magna suscipit ac. Integer fermentum velit vitae porttitor vestibulum. Morbi iaculis sed massa nec ultricies. Aliquam efficitur finibus dolor, et vulputate turpis pretium vitae. In lobortis lacus diam, ut varius tellus varius sed. Integer pulvinar, massa quis feugiat pulvinar, tortor nisi bibendum libero, eu molestie est sapien quis odio. Lorem ipsum dolor sit amet, consectetur adipiscing elit.";

    // default iTextSharp.tool.xml.html.table.Table (AbstractTagProcessor)
    // is at the <table>, **not <tr> level
    html.Append("<table style='page-break-inside:avoid;'>");
    html.AppendFormat(
        @"<tr><td style='border:1px solid #000;'>DEFAULT IMPLEMENTATION</td>
            <td style='border:1px solid #000;'>{0}</td></tr>",
        text
    );
    html.Append("</table>");

    // overriden implementation uses a custom HTML attribute to keep:
    // <tr> together - see TableProcessor
    html.AppendFormat("<table {0}>", TableProcessor.NO_ROW_SPLIT);
    for (int i = 0; i < repeatCount; ++i)
    {
        html.AppendFormat(
            @"<tr><td style='border:1px solid #000;'>{0}</td>
            <td style='border:1px solid #000;'>{1}</td></tr>",
            i, text
        );
    }
    html.Append("</table>");
    return html.ToString();
}