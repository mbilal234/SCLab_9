/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package poet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphPoet {

    private final Graph<String> graph = Graph.empty();

    // Abstraction function:
    //   Represents a poet with a word affinity graph derived from a corpus.
    // Representation invariant:
    //   None
    // Safety from rep exposure:
    //   The graph is private and final.

    /**
     * Create a new poet with the graph from corpus (as described above).
     *
     * @param corpus text file from which to derive the poet's affinity graph
     * @throws IOException if the corpus file cannot be found or read
     */
    public GraphPoet(File corpus) throws IOException {
        List<String> words = FileUtils.readWords(corpus);
        buildGraph(words);
    }

    // Check representation invariant
    private void checkRep() {
        // No specific representation invariant to check for now
    }

    // Build the word affinity graph from the given list of words
    private void buildGraph(List<String> words) {
        String prevWord = null;
        for (String word : words) {
            word = word.toLowerCase();
            graph.addVertex(word);
            if (prevWord != null) {
                graph.addEdge(prevWord, word);
            }
            prevWord = word;
        }
        checkRep();
    }

    /**
     * Generate a poem.
     *
     * @param input string from which to create the poem
     * @return poem (as described above)
     */
    public String poem(String input) {
        String[] inputWords = input.split("\\s+");
        StringBuilder poemBuilder = new StringBuilder();

        for (int i = 0; i < inputWords.length - 1; i++) {
            String word1 = inputWords[i].toLowerCase();
            String word2 = inputWords[i + 1].toLowerCase();

            List<String> bridgeWords = findBridgeWords(word1, word2);
            if (!bridgeWords.isEmpty()) {
                String bridgeWord = chooseMaxWeightBridge(bridgeWords, word1, word2);
                poemBuilder.append(inputWords[i]).append(" ").append(bridgeWord).append(" ");
            } else {
                poemBuilder.append(inputWords[i]).append(" ");
            }
        }

        poemBuilder.append(inputWords[inputWords.length - 1]);  // Append the last word
        return poemBuilder.toString().trim();
    }

    // Find bridge words between two words
    private List<String> findBridgeWords(String word1, String word2) {
        return graph.getSuccessors(word1);
    }

    // Choose the bridge word with the maximum weight
    private String chooseMaxWeightBridge(List<String> bridgeWords, String word1, String word2) {
        Map<String, Integer> weights = new HashMap<>();
        for (String bridgeWord : bridgeWords) {
            weights.put(bridgeWord, graph.getWeight(word1, bridgeWord) + graph.getWeight(bridgeWord, word2));
        }

        return weights.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }

    // String representation of the class
    @Override
    public String toString() {
        return "GraphPoet{" +
                "graph=" + graph +
                '}';
    }
}

