import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class TraversalTree {

  class Node {

    String val;
    Node left;
    Node right;

    public Node(String val, Node left, Node right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

    public Node(String val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    TraversalTree traversalTree = new TraversalTree();
    traversalTree.createTree(n, sc);

    sc.close();
  }

  private void createTree(int n, Scanner sc) {
    List<Node> nodes = new ArrayList<>();
    Map<String, Node> temp = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String node1 = sc.next();
      String node2 = sc.next();
      String node3 = sc.next();
      Node left = null;
      Node right = null;

      if (!Objects.equals(node2, ".")) {
        left = new Node(node2, null, null);
      }

      if (!Objects.equals(node3, ".")) {
        right = new Node(node3, null, null);
      }

      if (temp.get(node1) != null) {
        Node node = temp.get(node1);
        node.left = left;
        node.right = right;
      } else {
        Node node = new Node(node1, left, right);
        temp.put(node1, node);
      }
      temp.put(node2, left);
      temp.put(node3, right);
    }
    StringBuilder sb = new StringBuilder();
    preOrder(temp.get("A"), sb);
    System.out.println(sb);
    sb.setLength(0);
    inOrder(temp.get("A"), sb);
    System.out.println(sb);
    sb.setLength(0);
    postOrder(temp.get("A"), sb);
    System.out.println(sb);
  }

  private void postOrder(Node root, StringBuilder sb) {
    if(root == null) {
      return;
    }

    postOrder(root.left, sb);
    postOrder(root.right, sb);
    sb.append(root.val);
  }

  private void inOrder(Node root, StringBuilder sb) {
    if(root == null) {
      return;
    }

    inOrder(root.left, sb);
    sb.append(root.val);
    inOrder(root.right, sb);
  }

  private void preOrder(Node root, StringBuilder sb) {
    if(root == null) {
      return;
    }
    sb.append(root.val);
    preOrder(root.left, sb);
    preOrder(root.right, sb);
  }
}
