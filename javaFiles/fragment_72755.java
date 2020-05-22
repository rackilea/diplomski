public class Main {
    static JTable table;

    static CellInfo[][] data = {
            {new CellInfo("A"),new CellInfo("B"), new CellInfo("C")},
            {new CellInfo("D"),new CellInfo("E"), new CellInfo("F")},
            {new CellInfo("H"), new CellInfo("I"), new CellInfo("J")}
    };

    public static void Gui(){
        JFrame frame = new JFrame("Window");
        frame.setSize(800,600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        String[] columnNames = {"1","2","3"};


        TableModel model = new DefaultTableModel(data,columnNames){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        table = new JTable(model);
        JScrollPane sPane = new JScrollPane(table);

        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setColumnSelectionAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.setCellSelectionEnabled(false);
        table.setDefaultRenderer(Object.class, new Renderer());
        panel.add(sPane);
        frame.setContentPane(panel);
        frame.setVisible(true);

        Scanner in = new Scanner(System.in);
        System.out.print(in.nextLine());
        changeCellColor(0,0,Color.red,'f');
        table.repaint();
        System.out.print(in.nextLine());
        changeCellColor(1,0,Color.yellow,'b');
        table.repaint();

    }

    public static void changeCellColor(int row, int column, Color color, char backgroundOrForeground){
        data[row][column].color = color;
        data[row][column].bOrF = backgroundOrForeground;
    }
    public static void main(String[] args){
        Gui();
    }
}

class Renderer implements TableCellRenderer{
    Main m = new Main();
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
         JTextField editor = new JTextField();
            if (value instanceof CellInfo)
            {
                CellInfo info = (CellInfo) value;
                editor.setText(info.display);

                if (info.bOrF == 'b'){
                    editor.setBackground(info.color);
                }
                else if(info.bOrF == 'f'){
                    editor.setForeground(info.color);
                }
            }
            return editor;
    }
}

class CellInfo
{
    String display;
    char bOrF = ' ';
    Color color = Color.black;

    public CellInfo(String display)
    {
        this.display = display;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public void setBorF(char bOrF)
    {
        this.bOrF = bOrF;
    }
}