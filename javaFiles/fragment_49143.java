import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.impl.EditorsSplitters;
import com.intellij.openapi.fileEditor.impl.FileEditorManagerImpl;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Splitter;
import org.jdom.Element;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SplitterAction extends AnAction {

    public SplitterAction() {
        super("Splitter _Action");
    }

    private static class Info {

    }

    private static class SplitInfo extends Info {
        public Info    first;
        public Info    second;
        public boolean vertical;
        public float   proportions;
    }

    private static class FileInfo extends Info {
        public String[] fileNames;
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        final Project project = anActionEvent.getProject();
        final FileEditorManagerImpl fileEditorManager = (FileEditorManagerImpl) FileEditorManager.getInstance(project);
        EditorsSplitters splitters = fileEditorManager.getSplitters();
        // com.intellij.openapi.fileEditor.impl.EditorsSplitters.writeExternal() and
        // com.intellij.openapi.fileEditor.impl.EditorsSplitters#writePanel inspired this
        final Component component = splitters.getComponent(0);
        final SplitInfo infos = splitterVisitor(component);

        // or you could use this
        Element root = new Element("root");
        splitters.writeExternal(root);

        elementVisitor(root);

        // to restore from writeExternal the following should suffice
        splitters.readExternal(root);
        splitters.openFiles();
    }

    /**
     * Reads writeExternal output
     */
    private Info elementVisitor(Element root) {
        final Element splitter = root.getChild("splitter");
        if (splitter != null) {
            // see com.intellij.openapi.fileEditor.impl.EditorsSplitters#writePanel
            final SplitInfo splitInfo = new SplitInfo();
            // "vertical" or "horizontal"
            splitInfo.vertical = "vertical".equals(splitter.getAttributeValue("split-orientation"));
            splitInfo.proportions = Float.parseFloat(splitter.getAttributeValue("split-proportion"));
            Element first = splitter.getChild("split-first");
            if (first != null) {
                splitInfo.first = elementVisitor(first);
            }
            Element second = splitter.getChild("split-second");
            if (second != null) {
                splitInfo.second = elementVisitor(second);
            }
            return splitInfo;
        }
        final Element leaf = root.getChild("leaf");
        if (leaf != null) {
            final ArrayList<String> fileNames = new ArrayList<String>();
            for (Element file : leaf.getChildren("file")) {
                final String fileName = file.getAttributeValue("leaf-file-name");
                fileNames.add(fileName);
                // further attributes see com.intellij.openapi.fileEditor.impl.EditorsSplitters#writeComposite
            }
            final FileInfo fileInfo = new FileInfo();
            fileInfo.fileNames = fileNames.toArray(new String[fileNames.size()]);
            return fileInfo;
        }
        return null;
    }

    /**
     * Acts directly upon Component
     */
    private SplitInfo splitterVisitor(Component component) {
        if (component instanceof JPanel && ((JPanel) component).getComponentCount() > 0) {
            final Component child = ((JPanel) component).getComponent(0);
            if (child instanceof Splitter) {
                final Splitter splitter = (Splitter) child;
                final SplitInfo splitInfos = new SplitInfo();
                splitInfos.vertical = splitter.isVertical();
                splitInfos.proportions = splitter.getProportion();
                splitInfos.first = splitterVisitor(splitter.getFirstComponent());
                splitInfos.second = splitterVisitor(splitter.getSecondComponent());
                return splitInfos;
            }
            // TODO: retrieve file information
        }
        return null;
    }
}