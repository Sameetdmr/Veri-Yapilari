package com.company;

public class Main {

    public static void main(String[] args) {
        Agac a = new Agac();
        Node root = null;


        root = a.insert(root,5);
        root = a.insert(root,8);
        root = a.insert(root,6);
        root = a.insert(root,10);
        root = a.insert(root,4);
        root = a.insert(root,7);
        root = a.insert(root,1000);
        root = a.insert(root,9);

        System.out.println("Total Sum: " + a.getSumOfNodes(root));

        a.preorder(root);
        System.out.println();

        //root = a.deleteTree(root);

        System.out.println(a.recursiveSearch(root, 100));
        //System.out.println(a.recursiveSearch(root, 8));

        // a.findMinMaxValue(root);
        // System.out.println(a.maximum);
        // System.out.println(a.minimum);

         System.out.println("Total Leaf Nodes: " + a.getHeightOfTree(root));

        System.out.println("Total Sum: " + a.getDifferenceEvenOddvalues(root));

         a.getAverage(root);
        System.out.println(a.sum / a.count);

       System.out.println(a.sumOfLeafNodes(root));

        //System.out.println("Total Leaf Nodes: " + a.getNumberOfLeafNodes(root));

        System.out.println(a.getMax(root));

        //System.out.println(a.getMin(root));

        //root = a.delete(root, 4);

        System.out.println(a.getMin(root));




    }
}



class Node{
    Node left;
    Node right;
    int data;

}

class Agac
{
    public Node insert(Node node, int value){
        if(node == null){
            return createNewNode(value);
        }
        if(value<node.data){
            node.left=insert(node.left,value);
        }
        else if(value>node.data){
            node.right=insert(node.right,value);
        }
        return node;
    }

    public Node createNewNode(int k){
        Node a = new Node();
        a.data=k;
        a.left=null;
        a.right=null;
        return a;
    }

    public int getSumOfNodes(Node node) {
        if (node == null) {
            return 0;
        }

        return node.data + getSumOfNodes(node.left) + getSumOfNodes(node.right);
    }

    public void preorder(Node node) {
        if(node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public Node deleteTree(Node node) {
        if(node == null) {
            return null;
        }

        node.left = deleteTree(node.left);
        node.right = deleteTree(node.right);

        System.out.println("Deleting node " + node.data);
        node = null;
        return node;
    }

    public boolean recursiveSearch(Node node, int key) {
        if(node == null) {
            return false;
        }

        if(node.data == key) {
            return true;
        }

        return recursiveSearch(node.left, key) || recursiveSearch(node.right, key);
    }



    public int getHeightOfTree(Node node) {
        if (node == null) {
            return -1;
        }

        return Math.max(getHeightOfTree(node.left), getHeightOfTree(node.right)) + 1;
    }
    public int getDifferenceEvenOddvalues(Node node) {
        if (node == null) {
            return 0;
        }

        return node.data - getDifferenceEvenOddvalues(node.left) - getDifferenceEvenOddvalues(node.right);
    }
    int sum;
    int count;

    public void getAverage(Node node) {
        if (node == null) {
            return;
        }

        sum = sum + node.data;
        count = count + 1;

        getAverage(node.left);
        getAverage(node.right);
    }

    public int sumOfLeafNodes(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return node.data;
        }

        return sumOfLeafNodes(node.left) + sumOfLeafNodes(node.right);
    }



    public int getNumberOfLeafNodes(Node node) {
        if (node == null) {
            return 0;
        }

        if(node.left == null && node.right == null) {
            return 1;
        }

        return getNumberOfLeafNodes(node.left) + getNumberOfLeafNodes(node.right);
    }

    public int getMax(Node node) {
        if(node == null) {
            System.out.println("Tree is EMpty");
            return -1;
        }

        while(node.right != null) {
            node = node.right;
        }

        return node.data;
    }

    public int getMin(Node node) {
        if(node == null) {
            System.out.println("Tree is EMpty");
            return -1;
        }

        while(node.left != null) {
            node = node.left;
        }

        return node.data;
    }

    public Node delete(Node node, int val) {
        if(node == null) {
            return node;
        }

        if(val < node.data) {
            node.left = delete(node.left, val);
        } else if(val > node.data) {
            node.right = delete(node.right, val);
        } else {
            if(node.left == null || node.right == null) {
                Node temp = node.left != null ? node.left : node.right;

                if(temp == null) {
                    return null;
                } else {
                    return temp;
                }
            } else {
                Node successor = getSuccessor(node);
                node.data = successor.data;

                node.right = delete(node.right, successor.data);
                return node;
            }
        }

        return node;
    }

    public Node getSuccessor(Node node) {
        if(node == null) {
            return null;
        }

        Node temp = node.right;

        while(temp.left != null) {
            temp = temp.left;
        }

        return temp;
    }
}


