@additionalScripts = @{ctx().args.get("additionalScripts").asInstanceOf[List[Html]]}
@if(additionalScripts != null) {
    @for(additionalScript <- additionalScripts) {
        @additionalScript
    }
}