package sherif.java.sax;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class YourHandler extends DefaultHandler
{
    //TAGS      /\Sherif/\
    private boolean root = false;
    private boolean playbacklist = false;
    private boolean playback = false;
    private boolean name = false;
    private boolean ip = false;
    private boolean room = false;
    private boolean options = false;
    private boolean state = false;
    private boolean tracklist = false;
    private boolean track = false;

    public YourHandler()
    {
        //TODO      /\Sherif/\
    }

    @Override
    public void startDocument() throws SAXException
    {
        super.startDocument();
        //TODO      /\Sherif/\
    }

    @Override
    public void endDocument() throws SAXException
    {
        super.endDocument();
        //TODO      /\Sherif/\
    }

    @Override
    public void characters(char sherifCh[], int sherifSt, int sherifle)
    {
        String value = (new String(sherifCh)).substring(sherifSt, sherifSt + sherifle);
        if(root)
        {
            if(playbacklist)
            {
                if(playback)
                {
                    if(name)
                    {
                        //TODO      /\Sherif/\

                    }
                    else if(ip)
                    {
                        //TODO      /\Sherif/\

                    }
                    else if(room)
                    {
                        //TODO      /\Sherif/\

                    }
                    else if(options)
                    {
                        //TODO      /\Sherif/\

                    }
                    else if(state)
                    {
                        //TODO      /\Sherif/\

                    }
                }
            }
            else if(tracklist)
            {
                if(track)
                {
                    //TODO      /\Sherif/\

                }
            }
        }
    }

    @Override
    public void startElement(String sherifUr, String sherifNa, String sherifQn, org.xml.sax.Attributes sherifAt) throws SAXException
    {
        super.startElement(sherifUr, sherifNa, sherifQn, sherifAt);
        if(sherifNa.equals("root"))
        {
            this.root = true;
        }
        else if(sherifNa.equals("playbacklist"))
        {
            this.playbacklist = true;
        }
        else if(sherifNa.equals("playback"))
        {
            this.playback = true;
        }
        else if(sherifNa.equals("name"))
        {
            this.name = true;
        }
        else if(sherifNa.equals("ip"))
        {
            this.ip = true;
        }
        else if(sherifNa.equals("room"))
        {
            this.room = true;
        }
        else if(sherifNa.equals("options"))
        {
            this.options = true;
        }
        else if(sherifNa.equals("state"))
        {
            this.state = true;
        }
        else if(sherifNa.equals("tracklist"))
        {
            this.tracklist = true;
        }
        else if(sherifNa.equals("track"))
        {
            this.track = true;
        }
    }

    @Override
    public void endElement(String sherifUr, String sherifNa, String sherifQn) throws SAXException
    {
        super.endElement(sherifUr, sherifNa, sherifQn);
        if(sherifNa.equals("root"))
        {
            this.root = false;
        }
        else if(sherifNa.equals("playbacklist"))
        {
            this.playbacklist = false;
        }
        else if(sherifNa.equals("playback"))
        {
            this.playback = false;
        }
        else if(sherifNa.equals("name"))
        {
            this.name = false;
        }
        else if(sherifNa.equals("ip"))
        {
            this.ip = false;
        }
        else if(sherifNa.equals("room"))
        {
            this.room = false;
        }
        else if(sherifNa.equals("options"))
        {
            this.options = false;
        }
        else if(sherifNa.equals("state"))
        {
            this.state = false;
        }
        else if(sherifNa.equals("tracklist"))
        {
            this.tracklist = false;
        }
        else if(sherifNa.equals("track"))
        {
            this.track = false;
        }
    }
}