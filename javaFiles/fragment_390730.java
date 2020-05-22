public class RectComp implements Comparator<Rectangle>{

        public int compare(Rectangle r1, Rectangle r2) {

            double diff = r1.getHeight()*r1.getWidth() - r2.getHeight()*r2.getWidth();
            if(diff < 0)
                return -1;
            else if (diff == 0)
                return 0;
            else return 1;
        }
}