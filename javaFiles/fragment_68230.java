public class ColoredTitle
    {

        private String color;
        private Title title;

        public ColoredTitle(String color, Title title)
        {
            this.color = color;
            this.title = title;
        }

        public String getColor()
        {
            return color;
        }

        public void setColor(String color)
        {
            this.color = color;
        }

        public String getHeading()
        {
            return title.heading;
        }

        enum Title
        {
            FRONT_PAGE("Front Page"),
            FOOTER_TITLE("Footer Title");

            private String heading;

            Title(String title)
            {
                this.heading = title;
            }
        }
    }