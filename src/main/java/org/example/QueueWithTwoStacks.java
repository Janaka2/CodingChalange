package org.example;
import java.util.Stack;

public class QueueWithTwoStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueWithTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Push element x to the back of queue.
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue and returns that element.
    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            throw new RuntimeException("Queue is empty");
        }
    }

    public static void main(String[] args) {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
//
//    This problem was asked by Quora.
//
//        You are given a list of (website, user) pairs that represent users visiting websites. Come up with a program that identifies the top k pairs of websites with the greatest similarity.
//
//        For example, suppose k = 1, and the list of tuples is:
//
//        [('a', 1), ('a', 3), ('a', 5),
//        ('b', 2), ('b', 6),
//        ('c', 1), ('c', 2), ('c', 3), ('c', 4), ('c', 5)
//        ('d', 4), ('d', 5), ('d', 6), ('d', 7),
//        ('e', 1), ('e', 3), ('e': 5), ('e', 6)]
//        Then a reasonable similarity metric would most likely conclude that a and e are the most similar, so your program should return [('a', 'e')].