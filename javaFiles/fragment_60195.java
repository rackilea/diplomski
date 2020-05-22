for(Widgets widget: wid) {
        if(widget.getTypeString().contains("Triangle")) {
            LOGGER.info(widget.getName());

            Path path = new Path();
            path.setFillType(Path.FillType.EVEN_ODD);
            path.moveTo(a.x, a.y);

            // Lissage des lignes, meilleur rendu à l'écran
            paintTriangle.setAntiAlias(true);

            // Initialisation des paramètres
            seuils = JSONUtils.getSeuilAndColor(widget);
            value = JSONUtils.getValue(widget);

            // Récuperation de la couleur du seuil
            int color = this.getColorSeuil();
            String hexcolor = String.format("#%06X", (0xFFFFFF & color));

            // Colorier le triangle en fonction du dépassement du seuil
            paintTriangle.setColor(color);
            // Largeur de la bordure du triangle
            paintTriangle.setStrokeWidth(2);
            paintTriangle.setStyle(Paint.Style.FILL);

            // Création triangle dynamique
            if(canvas.getWidth() < c.x){
                a.set(150, a.y + 300);
                b.set(10, b.y + 300);
                c.set(310, c.y + 300);
                path.moveTo(a.x, a.y);
            }
            path.lineTo(a.x, a.y);
            path.lineTo(b.x, b.y);
            path.lineTo(c.x, c.y);
            path.close();
            canvas.drawPath(path, paintTriangle);
            canvas.drawText(widget.getName(), b.x+20, b.y-20, paintText);

            a.set(a.x + 310, a.y);
            b.set(b.x + 310, b.y);
            c.set(c.x + 310, c.y);
        }
    }