import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class StackSequence {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StackSequence ss = new StackSequence();
    int num = sc.nextInt();
    StringBuilder sb = ss.printOperator(sc, num);
    System.out.println(sb);
    sc.close();
  }

  private StringBuilder printOperator(Scanner sc ,int num) {
    StringBuilder sb = new StringBuilder();
    int pushCount = 0;
    int popCount = 0;
    String plus = "+"+"\n";
    String minus = "-"+"\n";
    Queue<Integer> temp = new ArrayDeque<>();
    for (int i = 0; i <num; i++) {
      int sequence = sc.nextInt();
      temp.add(sequence);
    }
    Stack<Integer> stack = new Stack<>();
    while (!(pushCount >= num && popCount >=num)) {
      int tempNum = temp.poll();
      if(pushCount<tempNum){
        int dif = tempNum-pushCount;
        for (int i = 0; i <dif ; i++) {
          sb.append(plus);
          pushCount++;
          stack.push(pushCount);
        }

        stack.pop();
        sb.append(minus);
        popCount++;
        continue;
      }

      if (pushCount > tempNum) {
        if (tempNum == stack.peek()) {
          stack.pop();
          sb.append(minus);
          popCount++;
        }else{
          return new StringBuilder("NO");
        }
      }
    }
    return sb;
  }
}
