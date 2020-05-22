for(int i=0; i<world1.getNumberofbugs(); i++)
        {
            Ellipse2D obscircle = new Ellipse2D.Double(getWorld1().bugArrayList.get(i).getHPosition(), getWorld1().bugArrayList.get(i).getVPosition(), 14, 15);
            graphicBugArrayList.add(i, obscircle);
            g2.setPaint(Color.RED);
            g2.fill(graphicBugArrayList.get(i));
            g2.draw(graphicBugArrayList.get(i));
        }