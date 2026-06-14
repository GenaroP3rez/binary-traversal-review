public class TraversalReview {

    /**
     * Returns three times the sum of the values in the tree.
     * 
     * If node is null returns 0.
     * 
     * @param node the root of the tree
     * @return three times the sum of the nodes in the tree
     */
    public static int tripleSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 3 * node.data
                + tripleSum(node.left)
                + tripleSum(node.right);
    }

    /**
     * Returns the sum of all positive values in the tree.
     * 
     * If the node is null or the tree contains only negative values, returns 0.
     * 
     * @param node the root of the tree
     * @return the sum of the positive values in the tree
     */
    public static int positiveSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int currentValue = 0;

        if (node.data > 0) {
            currentValue = node.data;
        }

        return currentValue
                + positiveSum(node.left)
                + positiveSum(node.right);
    }

    /**
     * Returns the maximum even value in the tree.
     * 
     * If node is null or there are no even values in the tree,
     * returns Integer.MIN_VALUE.
     * 
     * @param node the root of the tree
     * @return the maximum even value
     */
    public static int evenMax(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int leftMax = evenMax(node.left);
        int rightMax = evenMax(node.right);

        int maximum = Math.max(leftMax, rightMax);

        if (node.data % 2 == 0) {
            maximum = Math.max(maximum, node.data);
        }

        return maximum;
    }

    /**
     * Returns whether all children of every node in a binary tree have a value
     * strictly greater than their parent.
     * 
     * If a node has no children or the node is null, returns true.
     * 
     * @param node the root of the tree
     * @return whether all child nodes have strictly greater values than the parents
     */
    public static boolean isIncreasing(TreeNode node) {
        if (node == null) {
            return true;
        }

        if (node.left != null && node.left.data <= node.data) {
            return false;
        }

        if (node.right != null && node.right.data <= node.data) {
            return false;
        }

        return isIncreasing(node.left)
                && isIncreasing(node.right);
    }

    /**
     * Returns whether every node in the tree has either 0 or 2 children.
     * 
     * If node is null returns true.
     * 
     * @param node the root of the tree
     * @return whether every node has 0 or 2 children
     */
    public static boolean noSingleChildren(TreeNode node) {
        if (node == null) {
            return true;
        }

        if ((node.left == null && node.right != null)
                || (node.left != null && node.right == null)) {
            return false;
        }

        return noSingleChildren(node.left)
                && noSingleChildren(node.right);
    }

    /**
     * Returns whether at least one of the values in the tree is zero.
     * 
     * If node is null, returns false.
     * 
     * @param node the root of the tree
     * @return whether there is at least one zero value in the tree
     */
    public static boolean hasZero(TreeNode node) {
        if (node == null) {
            return false;
        }

        if (node.data == 0) {
            return true;
        }

        return hasZero(node.left)
                || hasZero(node.right);
    }

    /**
     * Returns whether there exists at least one value in the tree that is not
     * divisible by k.
     * 
     * If node is null, returns false.
     * 
     * @param node the root of the tree
     * @param k the value to check for divisibility by
     * @return whether at least one value is not divisible by k
     */
    public static boolean hasNonDivisible(TreeNode node, int k) {
        if (node == null) {
            return false;
        }

        if (node.data % k != 0) {
            return true;
        }

        return hasNonDivisible(node.left, k)
                || hasNonDivisible(node.right, k);
    }

    /**
     * Returns a String of the concatenated values of the tree traversed in-order.
     * 
     * If the node is null, returns an empty String.
     * 
     * @param node the root of the tree
     * @return a string with all the values of the tree concatenated in-order
     */
    public static String concatenate(TreeNode node) {
        if (node == null) {
            return "";
        }

        return concatenate(node.left)
                + node.data
                + concatenate(node.right);
    }
}