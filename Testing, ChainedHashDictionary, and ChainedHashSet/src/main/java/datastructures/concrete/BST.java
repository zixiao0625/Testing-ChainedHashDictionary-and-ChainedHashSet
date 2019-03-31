package datastructures.concrete;

/**
 * IMPORTANT NOTE: Do not change anything in this file. You do not need to change anything in this file for the 'Testing
 * isValidAVL' part.
 * <p>
 * Changes in this file will be overwritten by our automated testing script.
 */

/**
 * A basic Binary Search Tree class
 */
public class BST {
    private Node root;

    /**
     * Creates an empty Binary Search Tree.
     */
    public BST() {
        root = null;
    }

    /**
     * Creates a Binary Search Tree with the given values provided in
     * insertion order.
     * @param values an array containing the values for nodes in the BST
     */
    public BST(int[] values) {
        insertAll(values);
    }

    /**
     * @return the root Node
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Creates a Binary Search Tree with the given values provided in
     * insertion order.
     * @param values an array containing the values for nodes in the BST
     * @return a node representing a BST containing the given values
     */
    public void insertAll(int[] values) {
        for (int i = 0; i < values.length; i++) {
            insert(values[i]);
        }
    }

    /**
     * Empties the tree
     */
    public void reset() {
        root = null;
    }

    /**
     * Inserts the given int value into the Binary Search Tree
     * @param data an int to insert
     * @return a tree with the given value inserted
     */
    public void insert(int data) {
        if (!contains(data)) {
            root = insert(data, root);
        }
    }

    private Node insert(int data, Node node) {
        if (node == null) {
            node = new Node(data);
        } else if (data < node.data) {
            node.left = insert(data, node.left);
        } else if (data > node.data) {
            node.right = insert(data, node.right);
        }
        return node;
    }

    /**
     * Checks if the given int value exists in the Binary Search Tree
     * @param data an int
     * @return true if the given value exists and false otherwise
     */
    public boolean contains(int data) {
        return contains(data, root);
    }

    private boolean contains(int data, Node node) {
        if (node == null) {
            return false;
        }

        if (data > node.data) {
            return contains(data, node.right);
        } else if (data < node.data) {
            return contains(data, node.left);
        }
        return true;
    }

    /**
     * @return The height of the Binary Search Tree
     */
    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = 1 + height(node.left);
        int rightHeight = 1 + height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }


    /* Print tree values in inorder traversal */
    public void printInorder() {
        inorder(root);
        printTwoBlankLines();
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    /* Print tree values in preorder traversal */
    public void printPreorder() {
        preorder(root);
        printTwoBlankLines();
    }

    private void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    /* Print tree values in postorder traversal */
    public void printPostorder() {
        postorder(root);
        printTwoBlankLines();
    }

    private void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    /**
     * Prints the tree contents, one per line, following an inorder traversal
     * and using indentation to indicate node depth; prints right to left so
     * that the tree looks correct when the output is rotated 90 degrees.
     */
    public void printSideways() {
        printSideways(root, 0);
        printTwoBlankLines();
    }

    /**
     * Prints the tree with the given root, inorder, indenting each line to
     * the given level
     * @param node the node that roots the tree
     * @param level the current depth level
     */
    private void printSideways(Node node, int level) {
        if (node != null) {
            printSideways(node.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }

            System.out.println(node.data);
            printSideways(node.left, level + 1);
        }
    }

    private void printTwoBlankLines() {
        System.out.println();
        System.out.println();
    }


    /**
     * Return true if this BST is a valid AVL tree.
     *
     */
    public boolean isValidAVL() {
        /*
         * This implementation will be replaced with various buggy implementations in our automated testing.
         *
         * Do not modify this method or this file.
         *
         * To test if your AVL tree test methods can successfully catch all buggy implementations of this method,
         * push the commit to gitlab and see gitlab runner output.
         */
        return false;
    }


    /**
     * Inner class representing a Node in the Binary Search Tree
     */
    public class Node {
        public int data;
        public Node left;
        public Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}






