final String html = ...;


OutputSettings settings = new OutputSettings();
settings.escapeMode(Entities.EscapeMode.xhtml);

String cleanHtml = Jsoup.clean(html, "", Whitelist.relaxed(), settings);