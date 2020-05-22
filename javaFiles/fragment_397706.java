package org.dotmover;

import org.junit.Assert;
import org.junit.Test;

public class DotMoverTest {

    @Test
    public void testDotMoverForward() {
        final DotMover dotMover = new DotMover(...);
        final int newPos = dotMover.move(...);
        final int expectedNewPos = ...;
        Assert.assertEquals(expectedNewPos, newPos);
    }
}