/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package poet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * Tests for GraphPoet.
 */
public class GraphPoetTest {

    // Testing strategy
    // - Test the GraphPoet(File) constructor with different corpus files
    // - Test the poem(String) method with different input strings
    // - Test edge cases, such as empty input or empty corpus file
    // - Test representation invariance and safety from rep exposure

    @Test(expected = AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }

    @Test
    public void testGraphPoetConstructor() throws IOException {
        // Test the GraphPoet(File) constructor with a sample corpus file
        GraphPoet poet = new GraphPoet(new File("test/poet/sample-corpus.txt"));

        // Add assertions to check the state of the GraphPoet object after
        // initialization
        // For example, you can check if the graph is correctly constructed from the
        // corpus
        // You might also want to check the representation invariant and safety from rep
        // exposure.
        // Note: This test assumes the existence of a sample-corpus.txt file in the
        // specified path.
        // Make sure to replace it with the actual path and file for your test.
    }

    @Test
    public void testPoemGeneration() throws IOException {
        // Test the poem(String) method with different input strings
        GraphPoet poet = new GraphPoet(new File("test/poet/sample-corpus.txt"));

        // Test case 1
        String input1 = "Test the system.";
        String expectedOutput1 = "Test of the system.";
        assertEquals(expectedOutput1, poet.poem(input1));

        // Test case 2
        String input2 = "This is a test.";
        String expectedOutput2 = "This is a test.";
        assertEquals(expectedOutput2, poet.poem(input2));

        // Test case 3
        String input3 = "One small step.";
        String expectedOutput3 = "One small step.";
        assertEquals(expectedOutput3, poet.poem(input3));

        // Test case 4
        String input4 = "Graphs are interesting.";
        String expectedOutput4 = "Graphs are interesting.";
        assertEquals(expectedOutput4, poet.poem(input4));

        // Test case 5
        String input5 = "Empty input test.";
        String expectedOutput5 = "Empty input test.";
        assertEquals(expectedOutput5, poet.poem(input5));

        // Test case 6
        String input6 = "";
        String expectedOutput6 = "";
        assertEquals(expectedOutput6, poet.poem(input6));

        // Additional tests
        // Test case 7: Test with repeated words in the input
        String input7 = "Hello hello world world.";
        String expectedOutput7 = "Hello hello world world.";
        assertEquals(expectedOutput7, poet.poem(input7));

        // Test case 8: Test with a corpus containing only one word
        GraphPoet singleWordPoet = new GraphPoet(new File("test/poet/single-word-corpus.txt"));
        String input8 = "Test the system.";
        String expectedOutput8 = "Test the system.";
        assertEquals(expectedOutput8, singleWordPoet.poem(input8));

        // Test case 9: Test with a corpus containing only two words
        GraphPoet twoWordPoet = new GraphPoet(new File("test/poet/two-word-corpus.txt"));
        String input9 = "Test the system.";
        String expectedOutput9 = "Test of the system.";
        assertEquals(expectedOutput9, twoWordPoet.poem(input9));

        // Test case 10: Test with a corpus containing a mix of upper and lower case
        GraphPoet mixedCasePoet = new GraphPoet(new File("test/poet/mixed-case-corpus.txt"));
        String input10 = "Mixed Case Test.";
        String expectedOutput10 = "Mixed case test.";
        assertEquals(expectedOutput10, mixedCasePoet.poem(input10));
    }

    @Test
    public void testRepresentationInvariant() throws IOException {
        // Test the representation invariant, if applicable
        GraphPoet poet = new GraphPoet(new File("test/poet/sample-corpus.txt"));
        // Add assertions to check the representation invariant
        // For example, check that the graph meets the specified requirements
        assertTrue(poet.checkRep());
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
