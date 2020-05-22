import com.google.gwt.editor.client.CompositeEditor;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.editor.client.LeafValueEditor;

public abstract class AbstractSubTypeEditor<T, C extends T, E extends Editor<C>> implements CompositeEditor<T, C, E>, LeafValueEditor<T> {
        private EditorChain<C, E> chain;
        private T currentValue;
        private final E subEditor;

        /**
         * Construct an AbstractSubTypeEditor backed by the given sub-Editor.
         *
         * @param subEditor the sub-Editor that will be attached to the Editor
         *          hierarchy
         */
        public AbstractSubTypeEditor(E subEditor) {
                this.subEditor = subEditor;
        }

        /**
         * Returns the sub-Editor that the OptionalFieldEditor was constructed
         * with.
         *
         * @return an {@link Editor} of type E
         */
        public E createEditorForTraversal() {
                return subEditor;
        }

        public void flush() {
                currentValue = chain.getValue(subEditor);
        }

        /**
         * Returns an empty string because there is only ever one sub-editor used.
         */
        public String getPathElement(E subEditor) {
                return "";
        }

        public T getValue() {
                return currentValue;
        }

        public void onPropertyChange(String... paths) {
        }

        public void setDelegate(EditorDelegate<T> delegate) {
        }

        public void setEditorChain(EditorChain<C, E> chain) {
                this.chain = chain;
        }

        public void setValue(T value, boolean instanceOf) {
                if (currentValue != null && value == null) {
                        chain.detach(subEditor);
                }
                currentValue = value;
                if (value != null && instanceOf) {
                        chain.attach((C)value, subEditor);
                }
        }
}