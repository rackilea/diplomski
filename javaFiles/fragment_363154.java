private void Form1_Paint(object sender, PaintEventArgs e)
{
    // draw the cached Mandelbrot image
    e.Graphics.DrawImage(mandelbrotCache, new Point(0, 0));

    // draw the current rectangle
    e.Graphics.DrawRectangle(rectPen, CreateRectangle(startPoint, endPoint));
}