Adding following resolved the not redrawing upon scaling problem 

renderer.paint(molecule_, new AWTDrawVisitor(g2), new Rectangle2D.Double(0, 0, w, h), false);
            g2.dispose();
            }
            else