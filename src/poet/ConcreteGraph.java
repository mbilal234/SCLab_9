package poet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConcreteGraph<L> implements graph.Graph<L> {

    private final Map<L, Map<L, Integer>> outgoingEdges;

    public ConcreteGraph() {
        this.outgoingEdges = new HashMap<>();
    }

    public static <L> ConcreteGraph<L> empty() {
        return new ConcreteGraph<>();
    }

    @Override
    public boolean add(L vertex) {
        if (!outgoingEdges.containsKey(vertex)) {
            outgoingEdges.put(vertex, new HashMap<>());
            return true;
        }
        return false;
    }

    @Override
    public int set(L source, L target, int weight) {
        return 0;
    }

    // New method to add an edge
    public int addEdge(L source, L target) {
        add(source);
        add(target);

        Map<L, Integer> edges = outgoingEdges.get(source);
        int weight = edges.getOrDefault(target, 0) + 1;
        edges.put(target, weight);

        return weight;
    }

    // New method to get successors
    public Set<L> getSuccessors(L vertex) {
        return outgoingEdges.getOrDefault(vertex, new HashMap<>()).keySet();
    }

    // New method to get weight
    public int getWeight(String source, String target) {
        return outgoingEdges.getOrDefault(source, new HashMap<>()).getOrDefault(target, 0);
    }

    @Override
    public boolean remove(L vertex) {
        if (outgoingEdges.containsKey(vertex)) {
            // Remove outgoing edges
            for (L target : outgoingEdges.get(vertex).keySet()) {
                outgoingEdges.get(target).remove(vertex);
            }
            outgoingEdges.remove(vertex);

            return true;
        }
        return false;
    }

    @Override
    public Set<L> vertices() {
        return new HashSet<>(outgoingEdges.keySet());
    }

    @Override
    public Map<L, Integer> sources(L target) {
        return outgoingEdges.getOrDefault(target, new HashMap<>());
    }

    @Override
    public Map<L, Integer> targets(L source) {
        return outgoingEdges.getOrDefault(source, new HashMap<>());
    }

    // New method to choose max weight bridge
    public String chooseMaxWeightBridge(List<String> bridgeWords, String word1, String word2) {
        Map<String, Integer> weights = new HashMap<>();
        for (String bridgeWord : bridgeWords) {
            weights.put(bridgeWord, getWeight(word1, bridgeWord) + getWeight(bridgeWord, word2));
        }

        return weights.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }
}
