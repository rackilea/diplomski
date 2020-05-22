public class MyWidget extends Widget{

     public MyWidget(String params) {
         Document document = Document.get();
         DivElement divElement = document.createDiv();
         divElement.setInnerHtml(params);
         setElement(divElement); //important, widget needs to know it's root element
     }


     private static native void doJsMagic(Element element)/*-{ //notifies js about element
         $wnd.doSomething(element);
     }-*/;

     private static native void undoJsMagic(Element element)/*-{ 
        //notifies js that it should do some cleanup (if needed)
        //since it is unaware of GWT widget lifecycle
        $wnd.undoSomething(element)

     }-*/;

     @Override
     public void onAttach() {
        super.onAttach();
        doJsMagic(getElement());
     }

     @Override
     public void onDetach() {
        super.onDetach();
        undoJsMagic(getElement());
     }

}