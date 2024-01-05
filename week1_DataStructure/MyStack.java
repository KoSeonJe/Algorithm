import com.sun.tools.javac.Main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MyStack {
  private final List<Integer> stack = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    MyStack myStack = new MyStack();
    myStack.orderInput(br, n);

    br.close();
  }

  private void orderInput(BufferedReader br, int n) throws IOException {
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String orderName = st.nextToken();
      if (orderName.equals("push")) {
        int number = Integer.parseInt(st.nextToken());
        order(orderName, number);
        continue;
      }
      order(orderName, -1);
    }
  }

  private void order(String orderName, int n) {
    switch (orderName) {
      case "push":
        stack.add(n);
        break;
      case "top":
        if (stack.isEmpty()) {
          System.out.println(-1);
        } else {
          System.out.println(stack.get(stack.size() - 1));
        }
        break;
      case "size":
        System.out.println(stack.size());
        break;
      case "pop":
        if (stack.isEmpty()) {
          System.out.println(-1);
        } else {
          System.out.println(stack.remove(stack.size() - 1));
        }
        break;
      case "empty":
        if (stack.isEmpty()) {
          System.out.println(1);
        } else {
          System.out.println(0);
        }
        break;
    }
  }
}
