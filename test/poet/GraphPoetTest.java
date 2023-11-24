/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package poet;

import static org.junit.Assert.*;

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

    // TODO tests

}
