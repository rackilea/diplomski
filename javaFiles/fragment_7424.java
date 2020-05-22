package Ex1;

import java.util.ArrayList;

public class Catalogue 
{
private ArrayList <Textbook> catalogue;

public Catalogue ()
{
    catalogue = new ArrayList<Textbook>();
}

public void addTextbook (Textbook t) 
{
    catalogue.add(t);
 }

public boolean existTextbook(String title, String author)
{
    for(int i =0; i<catalogue.Size(); i++){
       Textbook t = catalogue.get(i);
       //you'll want getter and setter methods
       if(t.author.equals(author)&&t.title.equals(title))
           return truel
    }
}

public void deleteTextbook(String title)
{   
    for(int i =0; i<catalogue.Size(); i++){
       Textbook t = catalogue.get(i);
       if(t.title.equals(title)){
          catalogue.remove(i);
       }
    }

}

public String toString()
{
    return catalogue.toString(); 
}
}