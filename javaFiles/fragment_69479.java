@(content: Html)
@{
    var additionalScripts = ctx().args.get("additionalScripts").asInstanceOf[List[Html]];
    if(additionalScripts == null) {
        additionalScripts = new ArrayList[Html]();
        ctx().args.put("additionalScripts", additionalScripts)
    }

    val added = additionalScripts.add(content);
}