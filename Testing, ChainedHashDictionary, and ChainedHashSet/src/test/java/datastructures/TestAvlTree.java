package datastructures;

import datastructures.concrete.BST;
import misc.BaseTest;
import org.junit.Test;

public class TestAvlTree extends BaseTest {

    @Test(timeout = SECOND)
    public void testValidAVLTreeBasic() {
        BST tree = new BST(new int[]{2, 1, 3});
        assertEquals(true, tree.isValidAVL());
    }

    @Test(timeout = SECOND)
    public void testInvalidAVLTreeBasic() {
        BST tree = new BST(new int[]{1, 2, 3});
        tree.insert(4);
        assertEquals(false, tree.isValidAVL());
    }

    @Test(timeout = SECOND)
    public void testSmallBalance() {
        BST tree = new BST(new int[] {6, 2, 7});
        tree.insertAll(new int[] {9, 10});
        
        assertEquals(false, tree.isValidAVL());
    }
    
    @Test(timeout = SECOND)
    public void testMediumBalance() {
        BST tree = new BST(new int[] {1, 2, 3, 4, 5});
        tree.insertAll(new int[] {0, -1, -2, -3});
        assertEquals(false, tree.isValidAVL());
        tree.reset();
        tree.insertAll(new int[] {45, 34, 3, 87, 65});
        assertEquals(true, tree.isValidAVL());
    }
    
    @Test(timeout = SECOND)
    public void testLargeBalance() {
        BST tree = new BST(new int[] {5, 0, 7, -2, 1, 2, 3, 6, 8});
        assertEquals(false, tree.isValidAVL());
        tree = new BST(new int[] {7, 2, 1, 3, 9, 8, 11, 10, 12});
        assertEquals(true, tree.isValidAVL());
    }
    
    @Test(timeout = SECOND)
    public void testSingleNode() {
        BST tree = new BST(new int[] {6});
        assertEquals(true, tree.isValidAVL());
    }
    
    @Test(timeout = SECOND)
    public void testEmptyTree() {
        BST tree = new BST(new int[] {});
        assertEquals(true, tree.isValidAVL());
    }
    
    @Test(timeout = SECOND)
    public void testTreeWithNegative() {
        BST tree = new BST(new int[] {3, -1, -2, 7, 5, 9, 4, 6, 8});
        assertEquals(true, tree.isValidAVL());
        tree.insert(10);
        tree.insert(0);
        assertEquals(true, tree.isValidAVL());
        tree.insert(11);
        assertEquals(false, tree.isValidAVL());
    }
    
    @Test(timeout = SECOND)
    public void testRebalance() {
        BST tree = new BST(new int[] {2, 1, 3, 4, 5});
        assertEquals(false, tree.isValidAVL());
        tree.reset();
        assertEquals(true, tree.isValidAVL());
        tree.insertAll(new int[] {2, 1, 4, 3, 5});
        assertEquals(true, tree.isValidAVL());
        tree.insert(6);
        assertEquals(false, tree.isValidAVL());
        tree.insert(0);
        assertEquals(true, tree.isValidAVL());
    }
    
    @Test(timeout = SECOND)
    public void testUglyTree() {
        int sign = 1;
        int cur = 0;
        BST tree = new BST(new int[] {50, 60, 101, 102});
        assertEquals(false, tree.isValidAVL());
        tree.insertAll(new int[] {-1, -9, -10, -11});
        assertEquals(false, tree.isValidAVL());
        tree.insertAll(new int[] {1, 2, 3, 4});
        tree.insertAll(new int[] {-2, -3, -4});
        tree.insertAll(new int[] {59, 58, 57});
        tree.insertAll(new int[] {61, 62, 63});
        tree.insertAll(new int[] {100, 99, 98});
        assertEquals(false, tree.isValidAVL());
        tree.reset();
        tree.insert(cur);
        for (int i = 0; i < 10; i++) {
            cur = cur + sign * i;
            if (cur % 2 == 0) {
                sign = -1 * sign;
                tree.insert(cur);
            }
        }
        assertEquals(false, tree.isValidAVL());
        tree.insertAll(new int[] {9, 8, 10});
        assertEquals(true, tree.isValidAVL());
    }
    
    @Test(timeout = SECOND)
    public void testBalancedHeight() {
        BST tree = new BST(new int[] {1, -2, 0, -3, 3, 5, 4, 6, 2});
        assertEquals(true, tree.isValidAVL());
        tree.reset();
        tree.insertAll(new int[] {5, 4, 3, -2, -3, -1, 9, 10, 13, 14, 12});
        assertEquals(false, tree.isValidAVL());
    }
}
