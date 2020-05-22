public async Task<string> GetFileUrlAsync(string extension, string wopiFileUrl, WopiActionEnum action, WopiUrlSettings urlSettings = null)
    {
        var combinedUrlSettings = new WopiUrlSettings(urlSettings.Merge(UrlSettings));
        var template = await WopiDiscoverer.GetUrlTemplateAsync(extension, action);
        if (!string.IsNullOrEmpty(template))
        {
            // Resolve optional parameters
            var url = Regex.Replace(template, @"<(?<name>\w*)=(?<value>\w*)&*>", m => ResolveOptionalParameter(m.Groups["name"].Value, m.Groups["value"].Value, combinedUrlSettings));
            url = url.TrimEnd('&');

            // Append mandatory parameters
            url += "&WOPISrc=" + Uri.EscapeDataString(wopiFileUrl);

            return url;
        }
        return null;
    }