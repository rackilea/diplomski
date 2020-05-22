public class SupplyEditor extends Composite implements Editor<Supply> {

        public class ElecSupplyEditor implements Editor<ElecSupply> {
                public final TextBox profile = new TextBox();
                public final TextBox mtc = new TextBox();
                public final TextBox llf = new TextBox();
                public final TextBox area = new TextBox();
                public final TextBox core = new TextBox();
        }
        @Ignore
        final ElecSupplyEditor elecSupplyEditor = new ElecSupplyEditor();
        @Path("")
        final AbstractSubTypeEditor<Supply, ElecSupply, ElecSupplyEditor> elecSupplyEditorWrapper = new AbstractSubTypeEditor<Supply, ElecSupply, SupplyEditor.ElecSupplyEditor>(elecSupplyEditor) {
                @Override
                public void setValue(final Supply value) {
                        setValue(value, value instanceof ElecSupply);
                        if (!(value instanceof ElecSupply)) {
                                elecSupplyEditor.profile.setVisible(false);
                                elecSupplyEditor.mtc.setVisible(false);
                                elecSupplyEditor.llf.setVisible(false);
                                elecSupplyEditor.area.setVisible(false);
                                elecSupplyEditor.core.setVisible(false);
                        } else {
                                elecSupplyEditor.profile.setVisible(true);
                                elecSupplyEditor.mtc.setVisible(true);
                                elecSupplyEditor.llf.setVisible(true);
                                elecSupplyEditor.area.setVisible(true);
                                elecSupplyEditor.core.setVisible(true);
                        }
                }
        };

        public class GasSupplyEditor implements Editor<GasSupply> {
                public final TextBox mpr = new TextBox();
        }
        @Ignore
        final GasSupplyEditor gasSupplyEditor = new GasSupplyEditor();
        @Path("")
        final AbstractSubTypeEditor<Supply, GasSupply, GasSupplyEditor> gasSupplyEditorWrapper = new AbstractSubTypeEditor<Supply, GasSupply, SupplyEditor.GasSupplyEditor>(gasSupplyEditor) {
                @Override
                public void setValue(final Supply value) {
                        setValue(value, value instanceof GasSupply);
                        if (!(value instanceof GasSupply)) {
                                gasSupplyEditor.mpr.setVisible(false);
                        } else {
                                gasSupplyEditor.mpr.setVisible(true);
                        }
                }
        };

        public SupplyEditor () {
                final VerticalPanel page = new VerticalPanel();
                page.add(elecSupplyEditor.profile);
                page.add(elecSupplyEditor.mtc);
                page.add(elecSupplyEditor.llf);
                page.add(elecSupplyEditor.area);
                page.add(elecSupplyEditor.code);
                page.add(gasSupplyEditor.mpr);
                initWidget(page);
        }
}