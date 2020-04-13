import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Node {
    private final int level;
    private static final int MAX_LEVEL = 2;

    private final Set<Knowledge> knowledge;
    private final Set<Integer> usedTerms;

    private final int RelTerm;

    private Node parent = null;
    private Node falseSide;
    private Node trueSide;

    public Node(Set<Knowledge> knowledge) {
        level = 0;
        this.knowledge = knowledge;

        this.usedTerms = new HashSet<>();
        this.RelTerm = findRelTerm();
        usedTerms.add(this.RelTerm);

        generateChildren();
    }

    private Node(Node parent, Set<Knowledge> knowledge, HashSet<Integer> usedTerms) {
        this.level = parent.level  + 1;
        this.knowledge = knowledge;
        this.usedTerms = usedTerms;

        this.parent = parent;

        this.RelTerm = findRelTerm();
        this.usedTerms.add(this.RelTerm);

        generateChildren();
    }

    private static double log(double x) { // https://www.techiedelight.com/calculate-log-base-2-in-java/
        return (Math.log(x) / Math.log(2));
    }

    private int findRelTerm() {
        double relEntropy = Double.MAX_VALUE;
        int index = 0;

        if (knowledge.size() <= 0) return 0;

        Knowledge kn = knowledge.iterator().next();
        for (int i = 0; i < kn.size(); i++) {
            if (usedTerms.contains(i)) continue;

            Map<Boolean, Set<Knowledge>> knowledgeSets = generateSplits(i);
            double tEntropy = ((double) knowledgeSets.get(Boolean.TRUE).size() / knowledge.size()) * eCalc(kn, Boolean.TRUE, knowledgeSets, i);
            double fEntropy = ((double) knowledgeSets.get(Boolean.FALSE).size() / knowledge.size()) * eCalc(kn, Boolean.FALSE, knowledgeSets, i);;

            if (relEntropy > tEntropy + fEntropy) {
                relEntropy = tEntropy + fEntropy;
                index = i;
            }
        }
        System.out.println(relEntropy);
        return index;
    }

    private double eCalc(Knowledge val, Boolean side, Map<Boolean, Set<Knowledge>> knowledgeSets, int index) {
        double lcounter = 0;
        for (Knowledge knowledge : knowledgeSets.get(side)) {
            if(knowledge.getValue().equals(val.getValue())) {
                lcounter++;
            }
        }
        double prob = (lcounter / knowledgeSets.get(side).size());
        double nprob = ((knowledgeSets.get(side).size() - lcounter) / knowledgeSets.get(side).size());

        if (nprob == 0) {
            return 0;
        }
        return  (prob * log(1 / prob)) + (nprob * log(1 / nprob));
    }

    private Map<Boolean, Set<Knowledge>> generateSplits(int i) {
        Map<Boolean, Set<Knowledge>> knowledgeSets = new HashMap<>() {{
            put(Boolean.TRUE, new HashSet<>());
            put(Boolean.FALSE, new HashSet<>());
        }};

        for (Knowledge knowledge : this.knowledge) {
            if (knowledge.value(i))
                knowledgeSets.get(Boolean.TRUE).add(knowledge);
            else
                knowledgeSets.get(Boolean.FALSE).add(knowledge);
        }
        return knowledgeSets;
    }

    private void generateChildren() {
        if (level < MAX_LEVEL) {
            Map<Boolean, Set<Knowledge>> knowledgeSets = generateSplits(RelTerm);
            setNodes(knowledgeSets.get(Boolean.FALSE), knowledgeSets.get(Boolean.TRUE));
        }
    }

    private void setNodes(Set<Knowledge> falseSide, Set<Knowledge> trueSide) {
        this.falseSide = new Node(this, falseSide, new HashSet<>(usedTerms));
        this.trueSide = new Node(this, trueSide, new HashSet<>(usedTerms));
    }

    public String predict(Unknown unknown) {
        return "";
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\t".repeat(Math.max(0, level)));
        builder.append("Node-").append(level).append(":").append("\tAttribute To Test: ").append(RelTerm).append("\t(");

        Iterator<Knowledge> iterator = knowledge.iterator();
        int a = 0;
        if (iterator.hasNext()) {
            for (int i = 0; i < knowledge.size() - 1; i++) {
                Knowledge it = iterator.next();
                if (it.getValue().equals("A"))
                    a++;
                builder.append(it.name()).append(", ");
            }
            Knowledge it = iterator.next();
            if (it.getValue().equals("A"))
                a++;
            builder.append(it.name());


        }

        builder.append("): ");

        builder.append("(A: ").append(a);
        builder.append(", B: ").append(knowledge.size() - a).append(")").append(" ");

        if (trueSide != null) {
            builder.append("\n");
            builder.append("\t".repeat(Math.max(0, level)));

            builder.append("↳True:\n");
            builder.append(trueSide.toString());

            builder.append("\n");
            builder.append("\t".repeat(Math.max(0, level)));
            builder.append("↳False:\n");
            builder.append(falseSide.toString());
        }

        return builder.toString();
    }

}
