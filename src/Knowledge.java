import jdk.jshell.spi.SPIResolutionException;

import java.util.ArrayList;

/**
 * Represents a piece of data with a known class
 */
public class Knowledge extends Classifier {

    private static int counter = 1;
    public int mycounter = counter ++;
    private final String value;

    public Knowledge(String data) {
        super(new ArrayList<>());

        String[] aData = data.split(" ");
        for (int i = 0; i < aData.length - 1; i++) {
            this.values.add(Boolean.valueOf(aData[i]));
        }

        this.value = aData[aData.length - 1].toUpperCase();
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name() + super.toString();
    }

    public String name() {
        return value + mycounter;
    }
}
