class xyz extends Div implements PageConfigurator{

...

@Override
public void configurePage(InitialPageSettings settings) {
    settings.addInlineWithContents(
    InitialPageSettings.Position.PREPEND,
    "window.customElements=window.customElements||{}; 
     window.customElements.forcePolyfill=true; 
     window.ShadyDOM={force:true};", 
     InitialPageSettings.WrapMode.JAVASCRIPT);
}