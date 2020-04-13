import java.util.ArrayList;
import java.util.List;

public abstract class Classifier {
    protected final List<Boolean> values;

    protected Classifier(List<Boolean> values) {
        this.values = values;
    }

    public Boolean value(int index) {
        return values.get(index);
    }

    public int size() {
        return values.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        for (int i = 0; i < values.size() - 1; i++) {
            builder.append(values.get(i)).append(", ");
        }
        builder.append(values.get(values.size() - 1)).append(");");
        return builder.toString();
    }
}
