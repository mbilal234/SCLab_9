
package poet;



import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for GraphPoet.
 */
public class GraphPoetTest {

    // Testing strategy
    //   TODO

    // TODO tests for GraphPoet

    // TODO tests for checkRep

    // TODO tests for poem

    // TODO tests for safety from rep exposure
    @Test(expected = AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }

    @Test
    public void testGraphPoetConstructor() throws IOException {
        // Test the GraphPoet(File) constructor with a sample corpus file
        GraphPoet samplePoet = new GraphPoet(new File("test/poet/sample-corpus.txt"));

        // Add assertions to check the state of the GraphPoet object after
        // construction
        // For example, check that the graph is not empty
        //assertTrue(!samplePoet.graph.toString().isEmpty());
    }

    @Test
    public void testPoemGeneration1() throws IOException {
        GraphPoet samplePoet = new GraphPoet(new File("test/poet/sample-corpus.txt"));
        // Test the poem(String) method with different input strings

        String input1 = "Test of the mugar system.";
        String expectedOutput1 = "Test of of the the mugar mugar omni system.";
        assertEquals(expectedOutput1, samplePoet.poem(input1));
    }
    @Test
    public void testPoemGeneration2() throws IOException {
        GraphPoet samplePoet = new GraphPoet(new File("test/poet/sample-corpus.txt"));
        // Test case 2
        String input2 = "This is a test.";
        String expectedOutput2 = "This is is a a test test.";
        assertEquals(expectedOutput2, samplePoet.poem(input2));
    }
    @Test
    public void testPoemGeneration3() throws IOException {
        GraphPoet samplePoet = new GraphPoet(new File("test/poet/sample-corpus.txt"));
        // Test case 3
        String input3 = "One small step.";
        String expectedOutput3 = "One small step.";
        assertEquals(expectedOutput3, samplePoet.poem(input3));
    }
    @Test
    public void testPoemGeneration4() throws IOException {
        GraphPoet samplePoet = new GraphPoet(new File("test/poet/sample-corpus.txt"));
        // Test case 4
        String input4 = "Graphs are interesting.";
        String expectedOutput4 = "Graphs are interesting.";
        assertEquals(expectedOutput4, samplePoet.poem(input4));
    }

    @Test
    public void testPoemGeneration5() throws IOException {
        GraphPoet samplePoet = new GraphPoet(new File("test/poet/sample-corpus.txt"));
        // Test case 5
        String input5 = "Empty input test.";
        String expectedOutput5 = "Empty input test.";
        assertEquals(expectedOutput5, samplePoet.poem(input5));
    }
    @Test
    public void testPoemGenerationEmpty() throws IOException {
        GraphPoet samplePoet = new GraphPoet(new File("test/poet/sample-corpus.txt"));
        // Test case 6
        String input6 = "";
        String expectedOutput6 = "";
        assertEquals(expectedOutput6, samplePoet.poem(input6));
    }
    @Test
    public void testPoemGenerationRepeatedWords() throws IOException {
        GraphPoet samplePoet = new GraphPoet(new File("test/poet/sample-corpus.txt"));
        // Additional tests
        // Test case 7: Test with repeated words in the input
        String input7 = "Hello hello world world.";
        String expectedOutput7 = "Hello hello world world.";
        assertEquals(expectedOutput7, samplePoet.poem(input7));

    }

    @Test
    public void testPoemGenerationSingleWord() throws IOException {
        // Test case : Test with a corpus containing only one word
        GraphPoet singleWordPoet = new GraphPoet(new File("test/poet/single-word-corpus.txt"));
        String input8 = "Test the system.";
        String expectedOutput8 = "Test the system.";
        assertEquals(expectedOutput8, singleWordPoet.poem(input8));
    }
    @Test
    public void testPoemGenerationTwoWord() throws IOException {
        // Test case : Test with a corpus containing only two words
        GraphPoet twoWordPoet = new GraphPoet(new File("test/poet/two-word-corpus"));
        String input9 = "Test the system.";
        String expectedOutput9 = "Test system\n" +
                " the system.";
        assertEquals(expectedOutput9, twoWordPoet.poem(input9).replace("\r",""));
    }
    @Test
    public void testPoemGenerationMixedCase() throws IOException {
        // Test case 10: Test with a corpus containing a mix of upper and lower case
        GraphPoet mixedCasePoet = new GraphPoet(new File("test/poet/mixed-case-corpus"));
        String input10 = "Mixed Case Test.";
        String expectedOutput10 = "Mixed case Case test\n" +
                " Test.";
        assertEquals(expectedOutput10, mixedCasePoet.poem(input10).replace("\r",""));
    }

    @Test
    public void testSafetyFromRepExposure() throws IOException {
        // Test safety from rep exposure, if applicable
        GraphPoet poet = new GraphPoet(new File("test/poet/sample-corpus.txt"));
        // Add assertions to check that the representation is not exposed
        // For example, try to modify the internal state of the object through rep
        // exposure
        // and ensure that it is not possible
        // Make sure to respect encapsulation
    }
}
