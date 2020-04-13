import java.util.HashSet;
import java.util.Set;

public class Application {

    private final static String tuples =
            "False False True False False False False True B\n" +
            "True False True False True False False True B\n" +
            "True True True False False True True False A\n" +
            "False True False False True True False True B\n" +
            "True True True False True False True True B\n" +
            "False True True False False True False False B\n" +
            "True True False False True True True True B\n" +
            "True True True False True False False True B\n" +
            "True False True False True True False True B\n" +
            "True False True False True True False True B\n" +
            "False True True False True False True True B\n" +
            "False True True True False False True True A\n" +
            "True False False False True False True True B\n" +
            "False False True False True True True True B\n" +
            "False False True False True True False False B\n" +
            "False True True False False False True True A\n" +
            "False False True True True True False True B\n" +
            "False True True True False False True True A\n" +
            "False True True False False False False True A\n" +
            "False True True True False False True True A\n" +
            "True False True False False True True False B\n" +
            "False True True True False False True True A\n" +
            "False True True True True False True True A\n" +
            "True False False False False True True True A\n" +
            "False True False False True True True True B\n" +
            "True False True False True False False True B\n" +
            "False False True False True True True True B\n" +
            "True True False False True False True True B\n" +
            "True True False False True True True True B\n" +
            "True False True False True True True False B\n" +
            "True False False False False False True True B\n" +
            "False True True True False True True True A\n" +
            "True True True True False True True True A\n" +
            "True True False False False False False True B\n" +
            "True True False False False False True True B\n" +
            "False True True False False False False False B\n" +
            "True True False True False True True False A\n" +
            "False True True True True False True True A\n" +
            "False False True False True True False False B\n" +
            "False True True False False True False True B\n" +
            "False True True False True False False True B\n" +
            "False True True False True False True True B\n" +
            "True False False False True False False True B\n" +
            "True False True True False False False True A\n" +
            "True True False False True False False True B\n" +
            "False True False False True False False False B\n" +
            "True True True False False True False True B\n" +
            "True True False True False True True True A\n" +
            "False True True True True False True True A\n" +
            "True True True False True False False True B\n" +
            "True False True False True True False True B\n" +
            "True False True False True False False True B\n" +
            "True False True False True True False True B\n" +
            "False True False True False False True True A\n" +
            "False True False True True False True True A\n" +
            "False False True False True False True True A\n" +
            "True False True False False True False False B\n" +
            "False True True False True True False True B\n" +
            "False True True False True False False True B\n" +
            "True False True False True True False False B\n" +
            "True True False False False False False True A\n" +
            "False True True False True False True True A\n" +
            "True False True True False True False True B\n" +
            "True False True False True True False True B\n" +
            "True True True False True False False False B\n" +
            "False True True False False False True True A\n" +
            "False False False False True True False True B\n" +
            "True False True False True True False True B\n" +
            "True True True True False False False True B\n" +
            "False True True True False False True False A\n" +
            "True False True False True True True True B\n" +
            "False False True True False False True True A\n" +
            "True True True False False True False True B\n" +
            "False False False False True True False False A\n" +
            "True True False False False False True True A\n" +
            "False False True False True True False False B\n" +
            "True True True False True True False True B\n" +
            "False True True False False False True True A\n" +
            "False False False False True False True True B\n" +
            "False True True False True False False True B\n" +
            "False True False False False False False False B\n" +
            "True True True True False False True True A\n" +
            "True True True False True False False True B\n" +
            "True True True True False True True True A\n" +
            "True False False True True True True True B\n" +
            "True True False True True False True True B\n" +
            "False True False False True True False True B\n" +
            "True False False True True True False False B\n" +
            "False False True False True True False False B\n" +
            "False True True False True True True True A\n" +
            "False False True False True True True True B\n" +
            "True True True False True True True True B\n" +
            "False True False True False False True True A\n" +
            "False False True False True True True False B\n" +
            "True False True False True True True True B\n" +
            "True False True True True False False True B\n" +
            "True True True False False True True True A\n" +
            "True False False True False False False False A\n" +
            "False True True True False False True True A\n" +
            "False True False True False True True True A\n" +
            "False True False False True False True True A\n" +
            "False True True False False False True True A\n" +
            "False False False True True True True True B\n" +
            "False True True True False True True True A\n" +
            "True True True False True True False True B\n" +
            "False True True False True False True True B\n" +
            "True True True False True True True True B\n" +
            "True True False True True True True True B\n" +
            "True True True False False True False True B\n" +
            "False True False False False False True True A\n" +
            "True True True False False True True False B\n" +
            "True True False False False True True True A\n" +
            "True False True False True False True True B\n" +
            "True True False False True True False True B\n" +
            "True True False False True False False False B\n" +
            "True True True True False False False True A\n" +
            "True True False False True False False True B\n" +
            "True False True False False True True True B\n" +
            "True True False False True False False True B\n" +
            "True False False False True False False True B\n" +
            "True True True True False False True True A\n" +
            "True True False False True False False True B\n" +
            "False True True False False True False True A\n" +
            "False False True True True True False True B\n" +
            "True True True True False False True True A\n" +
            "True False True False True True False True B\n" +
            "True False True False False False False True B\n" +
            "True False True False True False False True B\n" +
            "False False False False False True True True A\n" +
            "True False False False True False True False B\n" +
            "True True False False True True False True B\n" +
            "False False False False True True False True B\n" +
            "False False False True False False False True A\n" +
            "False False True True False True True True A\n" +
            "True False False False True True False False B\n" +
            "False True True False False False False True B\n" +
            "True True True False True False False True B\n" +
            "False False True False False True False True B\n" +
            "False True True True True False True True A\n" +
            "True True False True False False False True A\n" +
            "True False True False True True True True B\n" +
            "False False True True True False True True A\n" +
            "False False False False False True True False A\n" +
            "True True False False False True True True B\n" +
            "False True False True False False True True A\n" +
            "True False True False True True True True B\n" +
            "True True True False True False False True B\n" +
            "False True True True False False True True A\n" +
            "True True True False True True True False B\n" +
            "False True True True True False False True A\n" +
            "True False True False True True False True B\n" +
            "True True False False True False True True B\n" +
            "True False True False True False False True B\n" +
            "False False True True False False True True A\n" +
            "False False True False True True False True B\n" +
            "True True True False True False False False B\n" +
            "False False False False True False False True B\n" +
            "True False False True False True False True B\n" +
            "False False True False True False True True B\n" +
            "True True True False False True False False B\n" +
            "True True False True False False True True A\n" +
            "True True True True False False True True A\n" +
            "True False True False False False False True B\n" +
            "True False True False True False False True B\n" +
            "True True True False True False True True B\n" +
            "False True False True False False True True A\n" +
            "True False True False False False True False B\n" +
            "False False True True True False True True A\n" +
            "True False False False True True True False B\n" +
            "False True True True True False False True A\n" +
            "False True True False False False True True A\n" +
            "False True True True False False True True A\n" +
            "False False False False True False False True B\n" +
            "True True False False False True False False B\n" +
            "True True False False True True True True B\n" +
            "True False True False True False True True B\n" +
            "True True False False False False True True B\n" +
            "True False True False True True False True B\n" +
            "False True True True True False True True A\n" +
            "False True True False False False True True A\n" +
            "True False True False True True False True B\n" +
            "True False True False True False False True B\n" +
            "True True False False True False True True B\n" +
            "False True True True False False True True A\n" +
            "False False False False True True True False A\n" +
            "True False True False True True False True B\n" +
            "False False False False False True False False B\n" +
            "True True True True True True False True B\n" +
            "False False True False True False False True B\n" +
            "True True True False True False False True B\n" +
            "True True False True False False True True A\n" +
            "False True True False True True False True B\n" +
            "False True True True False False True True A\n" +
            "True False True False True False False True B\n" +
            "False True True False True False True True A\n" +
            "False False True True True False True True A\n" +
            "True False True False True False True True B\n" +
            "True False True True False False True True A\n" +
            "False True True False False True False True B\n" +
            "False False False True False False True True A";

    private static final String bands =
            "True False True A\n" +
            "False True False B\n" +
            "True False False A\n" +
            "False True False B\n" +
            "True False True A\n" +
            "False True True B\n" +
            "True False False A\n" +
            "True True False B\n" +
            "False True False A\n" +
            "True False True B";

    public static void main(String[] args) {
        System.out.println("Teaching DB: ");
        Set<Knowledge> knowledgeSet = new HashSet<>();
        String[] knowledgeStrings = bands.split("\n");
        for (String kString : knowledgeStrings) {
            Knowledge knowledge = new Knowledge(kString);
            knowledgeSet.add(knowledge);
            System.out.println(knowledge);
        }
        System.out.println("DB final Size: " + knowledgeSet.size());

        System.out.println();

        Node node = new Node(knowledgeSet);
        System.out.println();
        System.out.println(node);

    }

}