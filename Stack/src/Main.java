public class Main {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        for (int i = 0; i <= 5; i++) {
            stack.printMe();
            System.out.println("Добавим " + i);
            stack.push(i);
        }
        stack.printMe();

        for (int i = 0; i < 2; i++) {
            System.out.println("Снимем со стека");
            System.out.println(stack.pop());
            stack.printMe();
        }

        System.out.println("Реверс!");
        stack = stack.revers();
        stack.printMe();

        for (int i = 0; i < 2; i++) {
            System.out.println("Снимем со стека");
            System.out.println(stack.pop());
            stack.printMe();
        }

        System.out.println("Реверс!");
        stack = stack.revers();
        stack.printMe();

        for (int i = 0; i < 2; i++) {
            System.out.println("Снимем со стека");
            System.out.println(stack.pop());
            stack.printMe();
        }
    }
}