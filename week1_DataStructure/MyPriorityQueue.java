import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MyPriorityQueue {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int caseNums = sc.nextInt();
    MyPriorityQueue priorityQueue = new MyPriorityQueue();
    List<Integer> temp = new ArrayList<>();
    for (int i = 0; i <caseNums; i++) {
      Queue<Integer> importance = new ArrayDeque<>();
      int docsNums = sc.nextInt();
      int findThPrint = sc.nextInt();
      for (int j = 0; j <docsNums ; j++) {
        importance.add(sc.nextInt());
      }
      int result = priorityQueue.findOrder(findThPrint, importance);
      temp.add(result);
    }

    for (int i : temp) {
      System.out.println(i);
    }
    sc.close();
  }

  private int findOrder(int findThPrint, Queue<Integer> importance) {
    int count = 0;
    Integer[] order = new Integer[importance.size()];
    for (int i = 0; i <order.length; i++) {
      order[i] = i;
    }
    List<Integer> calOrder = List.of(order);
    Queue<Integer> queOrder = new ArrayDeque<>(calOrder);

    while (!(importance.isEmpty())) {
      int max = Collections.max(importance);
      if (importance.peek().equals(max)) {
        importance.poll();
        Integer num = queOrder.poll();
        count++;
        if (num == findThPrint) {
          break;
        }
        continue;
      }
      importance.offer(importance.poll());
      queOrder.offer(queOrder.poll());
    }
    return count;
  }
}
