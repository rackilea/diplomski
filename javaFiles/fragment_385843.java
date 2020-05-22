@Grab(group='org.xhtmlrenderer', module='core-renderer', version='R8')
@Grab(group='net.sf.jtidy', module='jtidy', version='r938')

import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.RenderingHints
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import org.w3c.dom.Document
import org.w3c.tidy.Tidy
import org.xhtmlrenderer.simple.Graphics2DRenderer

def makeThumbnail(address) {
  // Size for the renderer
    def WIDTH = 1280
    def HEIGHT = 800

    // Setup Tidy
    def tidy = new Tidy()
    tidy.with {
        setQuiet(true)
        setXHTML(true)
        setHideComments(true)
        setInputEncoding("UTF-8")
        setOutputEncoding("UTF-8")
        setShowErrors(0)
        setShowWarnings(false)
    }

    def url = new URL(address)
    def doc = tidy.parseDOM(new ByteArrayInputStream(url.text.getBytes("UTF-8")), null)
    def os = new FileOutputStream("${System.env.USERPROFILE}/${url.getHost()}.png")

    def buf = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB)

    def graphics = buf.createGraphics()
    def renderer = new Graphics2DRenderer()

    renderer.with {
        setDocument(doc, address)
        layout(graphics, new Dimension(WIDTH, HEIGHT))
        render(graphics)
        graphics.dispose()
        ImageIO.write(buf, "png", os)
    }
}

makeThumbnail("http://en.wikipedia.org/")