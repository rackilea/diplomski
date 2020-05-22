//import java.awt.*;

//change the type of house to Polygon, if Rectangle doesn't meet
//your requirements
Rectangle house = new Rectangle(/* insert coordinates here*/);
Rectangle hero = new Rectangle(/* coordinates of the hero*/);

if(house.intersects(hero.x , hero.y , hero.width , hero.height))
     System.out.println("Can't pass");
else
     //move