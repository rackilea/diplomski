public javafx.scene.paint.Color getColor() {

        javafx.scene.paint.Color color = null;

        if (this.hits == -1) {
            color = javafx.scene.paint.Color.BLACK;

        } else if (this.hits == 0) {
            color = javafx.scene.paint.Color.TRANSPARENT;

        } else if (this.hits == 1) {
            color = javafx.scene.paint.Color.RED;

        } else if (this.hits == 2) {
            color = javafx.scene.paint.Color.YELLOW;

        } else if (this.hits == 3) {
           color = javafx.scene.paint.Color.GREEN;
        }

        return color;
 }