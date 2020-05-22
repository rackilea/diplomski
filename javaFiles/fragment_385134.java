public class VisibleTextStripper extends PDFTextStripper
{
    public VisibleTextStripper() throws IOException
    {
        super();
        registerOperatorProcessor("Do", new Invoke());
    }

    //
    // Hiding operations
    //
    void hide(String name)
    {
        Matrix ctm = getGraphicsState().getCurrentTransformationMatrix();
        float x = ctm.getXPosition();
        float y = ctm.getYPosition();
        float scaledWidth = ctm.getXScale();
        float scaledHeight = ctm.getYScale();

        for(List<TextPosition> characters : charactersByArticle)
        {
            Collection<TextPosition> toRemove = new ArrayList<TextPosition>();
            for (TextPosition character : characters)
            {
                Matrix matrix = character.getTextPos();
                float cx = matrix.getXPosition();
                float cy = matrix.getYPosition();
                float cw = character.getWidth();
                float ch = character.getHeight();
                if (overlaps(x, scaledWidth, cx, cw) && overlaps(y, scaledHeight, cy, cw))
                {
                    System.out.printf("Hidden by '%s': X: %f; Y: %f; Width: %f; Height: %f; Char: '%s'\n", name, cx, cy, cw, ch, character.getCharacter());
                    toRemove.add(character);
                }
            }
            characters.removeAll(toRemove);
        }
    }

    private boolean overlaps(float start1, float width1, float start2, float width2)
    {
        if (width1 < 0)
        {
            start1 += width1;
            width1 = -width1;
        }

        if (width2 < 0)
        {
            start2 += width2;
            width2 = -width2;
        }

        if (start1 < start2)
        {
            return start1 + width1 >= start2;
        }
        else
        {
            return start2 + width2 >= start1;
        }
    }

    //
    // operator processors
    //
    public static class Invoke extends OperatorProcessor
    {
        /**
         * Log instance.
         */
        private static final Log LOG = LogFactory.getLog(Invoke.class);

        /**
         * process : Do : Paint the specified XObject (section 4.7).
         * @param operator The operator that is being executed.
         * @param arguments List
         * @throws IOException If there is an error invoking the sub object.
         */
        public void process(PDFOperator operator, List<COSBase> arguments) throws IOException
        {
            VisibleTextStripper drawer = (VisibleTextStripper)context;
            COSName objectName = (COSName)arguments.get( 0 );
            Map<String, PDXObject> xobjects = drawer.getResources().getXObjects();
            PDXObject xobject = (PDXObject)xobjects.get( objectName.getName() );
            if ( xobject == null )
            {
                LOG.warn("Can't find the XObject for '"+objectName.getName()+"'");
            }
            else if( xobject instanceof PDXObjectImage )
            {
                drawer.hide(objectName.getName());
            }
            else if(xobject instanceof PDXObjectForm)
            {
                PDXObjectForm form = (PDXObjectForm)xobject;
                COSStream formContentstream = form.getCOSStream();
                // if there is an optional form matrix, we have to map the form space to the user space
                Matrix matrix = form.getMatrix();
                if (matrix != null) 
                {
                    Matrix xobjectCTM = matrix.multiply( context.getGraphicsState().getCurrentTransformationMatrix());
                    context.getGraphicsState().setCurrentTransformationMatrix(xobjectCTM);
                }
                // find some optional resources, instead of using the current resources
                PDResources pdResources = form.getResources();
                context.processSubStream( context.getCurrentPage(), pdResources, formContentstream );
            }
        }
    }
}