for (ERMRectangle rectangle2 : Rectangles) {
                if (rectangle != rectangle2 && rectangle2.position.intersects(Temp))//prevent overlapping
                {
                   Temp.x=rectangle.position.x ;
                   Temp.y=rectangle.position.y;

                }

            }