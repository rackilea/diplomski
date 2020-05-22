public class ContiguousArrayTest {
    @Test
    public void test() {
        assertFalse(ContiguousArray.isContiguous(new Integer[][] { 
            { 1, 2, 3, 3 }, 
            { 1, 4, 4, 5 }, 
            { 2, 6, 6, 5 }, 
            { 7, 7, 8, 8 } 
        }));

        assertFalse(ContiguousArray.isContiguous(new Character[][] { 
            { 'a', 'b' }, 
            { 'b', 'a' }, 
        }));

        assertTrue(ContiguousArray.isContiguous(new Character[][] { 
            { 'a', 'a', 'a' }, 
            { 'b', 'a' }, 
            { 'b' }, 
        }));

        assertTrue(ContiguousArray.isContiguous(new Integer[][] { 
            { 1, 2, 3, 3 }, 
            { 1, 4, 4, 5 }, 
            { 6, 7, 7, 5 }, 
            { 8, 8, 9, 9 } 
        }));

        assertTrue(ContiguousArray.isContiguous(new Integer[][] { 
            { 1, 2, 3, 3 }, 
            { 1, 1, 4, 5 }, 
            { 6, 1, 7, 5 }, 
            { 8, 8, 9, 9 } 
        }));

        assertTrue(ContiguousArray.isContiguous(new Integer[][] { 
            { 1, 2 }, 
            { 2, 2 }
        }));
    }
}