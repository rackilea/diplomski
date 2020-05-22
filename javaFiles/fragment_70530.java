package transport;

/**
 * ModeOfTransport description here
 * @author Michael
 * @link http://stackoverflow.com/questions/14097153/java-subclass-abstract-method-not-being-called/14097167#14097153
 * @since 12/30/12 10:46 PM
 */
public abstract class ModeOfTransport {
    public abstract void updateView(String name);
}

package transport;

/**
 * Bus description here
 * @author Michael
 * @link http://stackoverflow.com/questions/14097153/java-subclass-abstract-method-not-being-called/14097167#14097153
 * @since 12/30/12 10:47 PM
 */
public class Bus extends ModeOfTransport {
    @Override
    public void updateView(String name) {
        System.out.println("BUS");
    }
}

package transport;

/**
 * Train description here
 * @author Michael
 * @link
 * @since 12/30/12 10:48 PM
 */
public class Train extends ModeOfTransport {
    @Override
    public void updateView(String name) {
        System.out.println("TRAIN");
    }
}


package transport;

/**
 * TransportVisitor description here
 * @author Michael
 * @link http://stackoverflow.com/questions/14097153/java-subclass-abstract-method-not-being-called/14097167#14097153
 * @since 12/30/12 10:49 PM
 */
public class TransportVisitor {
    public static void main(String[] args) {
        TransportVisitor visitor = new TransportVisitor();
        String [] types = { "TRAIN", "BUS" };
        for (String type : types) {
            visitor.updateView(type);
        }
    }

    public void updateView(String transportTypeName) {
        switch(transportTypeName) {
            case "BUS":
                handleInfo(new Bus());
                break;
            case "TRAIN":
                handleInfo(new Train());
                break;
            default:
                break;
        }
    }

    private void handleInfo(ModeOfTransport transportType) {
        transportType.updateView((String) null);
    }
}