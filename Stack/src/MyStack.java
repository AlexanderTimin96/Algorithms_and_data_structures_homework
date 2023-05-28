import java.util.Stack;

public class MyStack<T> {
    private class Node<T> {
        private final T value;
        private final Node<T> prev;

        public Node(T value, Node<T> prev) {
            this.value = value;
            this.prev = prev;
        }

        public Node<T> getPrev() {
            return prev;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private Node<T> head = null;

    public boolean isEmpty() {
        return head == null;
    }

    public void push(T value) {
        if (isEmpty()) {
            head = new Node<>(value, null);
        } else {
            head = new Node<>(value, head);
        }
    }

    public Node<T> pop() {
        if (!isEmpty()) {
            Node<T> node = head;
            head = head.getPrev();
            return node;
        }
        return null;
    }

    public void printMe() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            Node<T> node = head;
            while (!(node == null)) {
                stringBuilder.append(node);
                if (!(node.prev == null)) {
                    stringBuilder.append(" -> ");
                }
                node = node.prev;
            }
            System.out.println(stringBuilder);
        }
    }

    public MyStack<T> revers() {
        MyStack<T> newStack = new MyStack<>();
        while (!this.isEmpty()) {
            newStack.push((T) this.pop());
        }
        return newStack;
    }
}
