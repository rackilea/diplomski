public class NewLineAutoEditStrategy implements IAutoEditStrategy {

    public void customizeDocumentCommand(IDocument document, DocumentCommand command) {
        if (command.length == 0 && command.text != null) {
            // is not a replace

            if (TextUtilities.equals(document.getLegalLineDelimiters(), command.text) != -1) {
                // text being insterted is a legal line delimiter

                command.text += getMagicNumber();
            }
        }
    }

}