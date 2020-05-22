import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

public class GroupSpinner
{
    private int groupMaximum;

    private List<GroupSpinnerNumberModel> models = new ArrayList<GroupSpinnerNumberModel>();

    public GroupSpinner(int maximum)
    {
        this.groupMaximum = maximum;
    }

    public SpinnerNumberModel createGroupModel(int value, int minimum, int maximum, int step)
    {
        GroupSpinnerNumberModel model = new GroupSpinnerNumberModel(value, minimum, maximum, step, this);
        models.add( model );

        return model;
    }

    public Object getNextValue(int currentValue, int step)
    {
        int maximum = getGroupValue() + step;

        if (maximum > groupMaximum)
        {
            return currentValue;
        }
        else
        {
            groupValueUpdated(maximum);
            int nextValue = currentValue + step;
            return nextValue;
        }
    }

    public int getGroupValue()
    {
        int maximum = 0;

        for (GroupSpinnerNumberModel model: models)
        {
            maximum += model.getNumber().intValue();
        }

        return maximum;
    }

    private void groupValueUpdated(int value)
    {
        System.out.println(value);
    }

    public class GroupSpinnerNumberModel extends SpinnerNumberModel
    {
        private GroupSpinner model;

        public GroupSpinnerNumberModel(int value, int minimum, int maximum, int step, GroupSpinner model)
        {
            super(value, minimum, maximum, step);

            this.model = model;
        }

        public Object getNextValue()
        {
            int currentValue = super.getNumber().intValue();
            int step = super.getStepSize().intValue();

            return model.getNextValue(currentValue, step);
        }
    }

    private static void createAndShowGUI()
    {
        JPanel panel = new JPanel( new GridLayout(0, 1) );

        GroupSpinner group = new GroupSpinner(10);

        JSpinner number1 = new JSpinner( group.createGroupModel(0, 0, 10, 1) );
        panel.add(number1);
        panel.add( new JSpinner( group.createGroupModel(0, 0, 10, 1) ) );
        panel.add( new JSpinner( group.createGroupModel(0, 0, 10, 1) ) );
        panel.add( new JSpinner( group.createGroupModel(0, 0, 10, 1) ) );

        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater( () -> createAndShowGUI() );
/*
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
*/
    }

}