package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public final class BinaryTrees {
    private BinaryTrees(){
        //do nothing
    }

    /**
     * A simple way to create a binary tree from an array.
     * Time complexity : O(n), since all values of the array will be traversed
     *
     * @param arr : An array of numbers
     * @param i : The position of the number in the array
     * @return root: The root node
     * */

    public static BTNode createBinaryTree(int[] arr, int i){
        if(i >= arr.length) return null;
        BTNode root = new BTNode(arr[i]);
        root.left = createBinaryTree(arr, 2*i + 1);
        root.right = createBinaryTree(arr, 2*i + 2);
        return root;
    }

    /**
     * To add an element in a Binary tree, we use level order to go over every element in the tree from left to right at
     * each level. The first element which matches the requirement of having either both left and right children as null or
     * having only right child as null, is selected for the insertion.
     *
     * @param root The root of the tree
     * @param i The element to be inserted
     *
     * @return void
     * */
    public static void insertElement(BTNode root, int i){
        List<BTNode> queue = new ArrayList<BTNode>();
        queue.add(root);
        boolean flag = false;
        while(!flag){
            BTNode node = queue.get(0);
            queue.remove(0);
            if(node.left == null && node.right == null) {
                flag = true;
                node.left = new BTNode(i);
            }else if(node.right == null) {
                flag = true;
                node.right = new BTNode(i);
            }else{
                queue.add(node.left);
                queue.add(node.right);
            }
        }
    }

    /**
     * To delete a node in a tree, we traverse down the tree, until we find the node to be deleted. Once found, we also
     * need to find its replacement. To find the replacement, we find out the last element inserted into the tree, i.e.
     * the right most element, and bubble up its value through the recursion stack. This replacement of value means that
     * the sub tree under the replaced value need not be adjusted.
     *
     * @param root The root of the tree
     * @param target The value of the node to be replaced
     *
     * @return BTNode The root of the tree
     * */

    public static BTNode deleteElement(BTNode root, int target){
        if(root == null) return null;

        if(root.data == target){
            if(root.right == null && root.left == null) return null;
            else if(root.right ==  null) return root.left;
            else if(root.left == null) return root.right;
            else{
                int val = findRightMostElement(root);
                root.data = val;
            }
        }else{
            deleteElement(root.left, target);
            deleteElement(root.right, target);
        }
        return root;
    }

    public static int findRightMostElement(BTNode root){
        if(root.right.right == null){
            BTNode temp = root.right;
            if(root.right.left != null) root.right = root.right.left;
            else root.right = null;
            return temp.data;
        }else{
            return findRightMostElement(root.right);
        }
    }

    /**
     * The InOrder traversal happens in the order - L-D-R. The below method uses recursion to do the inorder traversal
     * stores the nodes in a list
     *
     * @param root The root of the tree
     * @param inOrderList The list used to store the nodes in the Inorder format
     *
     * @return void
     * */
    public static void inOrderRecursion(BTNode root, List<BTNode> inOrderList){
        if(root == null) return;
        inOrderRecursion(root.left, inOrderList);
        inOrderList.add(root);
        inOrderRecursion(root.right, inOrderList);
    }

    /**
     * The Iterative InOrder traversal uses a stack to store the nodes as we traverse down a tree in the L-D-R manner.
     * Once the end of the tree is reached, the node is popped from the stack and stored in the list and the right side
     * is now traversed.
     *
     * @param root The root of the tree
     *
     * @return inOrderList A list of all nodes stored in L-D-R order
     * */
    public List<BTNode> inOrderIterative(BTNode root){
        Stack<BTNode> stack = new Stack<BTNode>();
        List<BTNode> inorderList = new ArrayList<BTNode>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            inorderList.add(root);
            if(root.right != null) root = root.right;
        }
        return inorderList;
    }

    /**
     * The preOrder traversal is in the order - D-L-R. As we traverse the tree in the order, we store the nodes in a list.
     *
     * @param root The root of the tree;
     * @param preOrderList The list which will be populated with the nodes of the tree;
     *
     * @return void
     * */
    public static void preOrderRecursion(BTNode root, List<BTNode> preOrderList){
        if(root == null) return;
        preOrderList.add(root);
        preOrderRecursion(root.left, preOrderList);
        preOrderRecursion(root.right, preOrderList);
    }


    /**
     * The preOrder traversal is in the order D-L-R. A stack is used to store the nodes as we traverse down a tree. A list
     * is used to store the tree in the Pre-Order format.
     *
     * @param root The root of the tree;
     *
     * @return List<BTNode> The list containing all elements from the tree in PreOrder manner
     * */
    public static List<BTNode> preOrderIterative(BTNode root){
        Stack<BTNode> stack = new Stack<BTNode>();
        List<BTNode> preOrderList = new ArrayList<BTNode>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                preOrderList.add(root);
                if(root.right != null) stack.push(root.right);
                root = root.left;
            }
            root = stack.pop();
        }
        return preOrderList;
    }

    /**
     *The Post Order traversal has the format - L-R-D. As we traverse down the tree, we use the list to store the nodes
     * in the Post Order format
     *
     * @param root The root of the tree
     * @param postorderList The list which will store the elements of the tree in the PostOrder manner
     *
     * @return void
     * */
    public static void postOrderRecursion(BTNode root, List<BTNode> postorderList){
        if(root != null){
            postOrderRecursion(root.left, postorderList);
            postOrderRecursion(root.right, postorderList);
            postorderList.add(root);
        }
    }
}

