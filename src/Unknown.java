import java.util.ArrayList;

/**
 * Represents a piece of data with an unknown class
 */
public class Unknown extends Classifier {
    protected Unknown(String data) {
        super(new ArrayList<>());

        String[] aData = data.split(" ");
        for (int i = 0; i < aData.length; i++) {
            this.values.add(Boolean.valueOf(aData[i]));
        }
    }
}
