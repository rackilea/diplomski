import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.utils.Align;

public class Paragraph extends WidgetGroup {

    private static final class RowData {

        final List<Actor> elements;
        final float size;
        final boolean lastRow;

        RowData(List<Actor> elements, float size, boolean lastRow) {
            this.elements = elements;
            this.size = size;
            this.lastRow = lastRow;
        }

        static RowData createNewRow(List<Actor> elements, float size) {
            return new RowData(elements, size, false);
        }

        static RowData createLastRow(List<Actor> elements, float size) {
            return new RowData(elements, size, true);
        }
    }

    private Label space;

    public Paragraph(String text, float width, LabelStyle style) {

        super();
        setWidth(width);

        this.space = new Label(" ", style);
        this.space.pack();

        String[] words = text.split(" ");
        for (String word : words) {

            Label label = new Label(word, style);
            label.pack();

            addActor(label);
        }

        arrangeActors();
    }

    private void arrangeActors() {

        float size = 0;
        float height = space.getHeight();

        List<RowData> rows = new ArrayList<RowData>(); 
        List<Actor> elements = new ArrayList<Actor>();

        Actor[] actors = this.getChildren().begin();

        for (Actor actor : actors) {

            if (actor != null) {
                if (elements.isEmpty()) {

                    elements.add(actor);
                    size = actor.getWidth();

                } else if (size + space.getWidth() + actor.getWidth() <= this.getWidth()) {

                    elements.add(actor);
                    size += (space.getWidth() + actor.getWidth());

                } else {

                    rows.add(RowData.createNewRow(elements, size));

                    elements = new ArrayList<Actor>();
                    height += space.getHeight();

                    elements.add(actor);
                    size = actor.getWidth();
                }
            }
        }

        this.getChildren().end();

        rows.add(RowData.createLastRow(elements, size));

        height += space.getHeight();
        setHeight(height);

        float y = height;

        for (RowData data : rows) {

            float spacing = space.getWidth();
            if (data.lastRow == false) {
                spacing += ((getWidth() - data.size) / data.elements.size()); 
            }

            Actor element = data.elements.get(0);
            element.setPosition(0, y, Align.topLeft);

            float x = element.getWidth();

            for (int i = 1; i < data.elements.size(); i++) {

                element = data.elements.get(i);                
                element.setPosition(x + spacing, y, Align.topLeft);
                x += (spacing + element.getWidth());
            }

            y -= this.space.getHeight();
        }
    }

    @Override
    public float getPrefWidth () {
        return getWidth();
    }

    @Override
    public float getPrefHeight () {
        return getHeight();
    }
}