public partial class Form1 : Form
{
    public Form1()
    {
        InitializeComponent();

        // this reduces the flickering
        this.DoubleBuffered = true;
    }
}