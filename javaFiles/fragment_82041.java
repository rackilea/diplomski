package src;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import com.sun.javafx.css.converters.FontConverter.FontStyleConverter;

import src.MainWindow.LogEntry;
import src.MainWindow.LogType;

public class MainWindow {

    public enum LogType {
        // @formatter:off
        ERROR("Error", Color.RED, Font.BOLD),
        COMMENT("Comment", Color.BLUE, Font.ITALIC),
        READ_INFO("Read_Info", Color.BLACK, 0),
        ACTION("Action", Color.YELLOW, 0),
        PARAM_ERROR("Param_Error", Color.RED, Font.ITALIC | Font.BOLD);
        // @formatter:on

        String text;
        Color color;
        int fontStyle;

        private LogType(String s, Color color, int fontStyle) {
            this.text = s;
            this.color = color;
            this.fontStyle = fontStyle;
        }

        public void setText(String s) {
            this.text = s;
        }

        public String getText() {
            return text;
        }

        public int getFontStyle() {
            return fontStyle;
        }

        public Color getColor() {
            return color;
        }
    };

    public static class LogEntry {
        private LogType type;
        private String text;

        public LogEntry(LogType type, String text) {
            this.type = type;
            this.text = text;
        }

        public LogType getType() {
            return type;
        }

        public String getText() {
            return text;
        }
    }

    private JFrame frmNavdng;
    private static DefaultListModel<LogEntry> logListModel = new DefaultListModel<>();
    private static JList<LogEntry> log_List = new JList<>(logListModel);

    public MainWindow() {
        initialize();
    }

    public static void add_Log_Line(LogType type, String s) {
        // add action to the log list
        type.setText(s);
        logListModel.addElement(new LogEntry(type, s));
        log_List.ensureIndexIsVisible(log_List.getLastVisibleIndex());
    }

    private void initialize() {
        /** Frame Initialisation */
        frmNavdng = new JFrame();
        frmNavdng.setFont(new Font("Tahoma", Font.PLAIN, 12));
        frmNavdng.setTitle("list_window");
        frmNavdng.setResizable(false);
        frmNavdng.setBounds(100, 100, 640, 400);
        frmNavdng.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmNavdng.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, frmNavdng.getWidth(), frmNavdng.getHeight());
        frmNavdng.getContentPane().add(scrollPane);
        scrollPane.setViewportView(log_List);
        log_List.setToolTipText("history of the last actions");
        log_List.setVisibleRowCount(10);
        log_List.setValueIsAdjusting(true);
        log_List.setFont(new Font("Tahoma", Font.PLAIN, 10));
        log_List.setCellRenderer(new MyCellRenderer());
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow window = new MainWindow();
                    window.frmNavdng.setVisible(true);
                    LogType[] values = LogType.values();
                    for (LogType logType : values) {
                        add_Log_Line(logType, "This is log type " + logType.getText());
                    }
                } catch (Exception e) {
                    e.toString();
                }
            }
        });
    }

}

class MyCellRenderer extends DefaultListCellRenderer {

    private static final long serialVersionUID = 1L;

    public MyCellRenderer() {
        setOpaque(true);
    }

    @Override public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
            boolean cellHasFocus) {
        LogEntry entry = (LogEntry) value;

        value = entry.getText();

        Color background = Color.white;
        Color foreground = entry.getType().getColor();

        Font font = list.getFont();

        font = new Font(list.getFont().getFontName(), entry.getType().getFontStyle(), list.getFont().getSize());

        if (isSelected)
            background = Color.lightGray;

        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        c.setForeground(foreground);
        c.setBackground(background);
        c.setFont(font);

        return c;
    }
}