import java.util.Scanner;

// Using the Reverse-Polish Notation calculator
// A calculator which will calculate equations where the operator follows the operands
class StackNode {
    // Stack is a data structure which would add items to the top of the stack and reomved from the top
    // of the stack
    public StackNode(double data, StackNode underneath) {
        this.data = data;
        this.underneath = underneath;
    }
    public StackNode underneath;
    public double data;
}
// Creating a class of RPN with a constructor creating an object
// As well as the use of its attributes and methods
class RPN {
    public void into(double newData) {
        StackNode newNode = new StackNode(newData, top);
        top = newNode;
    }

    public double pull() {
        double topData = top.data;
        top = top.underneath;
        return topData;
    }

    public RPN(String command) {
        top = null;
        this.command = command;
    }

    public double get() {
        // initialize the variables
        double a, b;
        int j;
        double number = 0;
        for (int i = 0; i < command.length(); i++) {
            // If it is a digit
            number = 0;
            if (Character.isDigit(command.charAt(i))) {

                // Get a string of the number
                String temp = "";
                for (j = 0; (j < 100) && (Character.isDigit(command.charAt(i)) || (command.charAt(i) == '.')); j++, i++) {
                    temp = temp + String.valueOf(command.charAt(i));
                }

                // Convert to double and add to the stack
                // Push is an operation that allows for an item to be added to the top of the stack
                number = Double.parseDouble(temp);
                push(number);
            } else if (command.charAt(i) == '+') {
                b = push(number);
                a = push(number);
                into(a + b);
            } else if (command.charAt(i) == '-') {
                b = push(number);
                a = push(number);
                into(a - b);
            } else if (command.charAt(i) == '*') {
                b = push(number);
                a = push(number);
                into(a * b);
            } else if (command.charAt(i) == '/') {
                b = push(number);
                a = push(number);
                into(a / b);
            } else if (command.charAt(i) == '^') {
                b = push(number);
                a = push(number);
                into(Math.pow(a, b));
            } else if (command.charAt(i) != ' ') {
                throw new IllegalArgumentException();
            }
        }

        double val = push(number);

        // Handle potential exception
        if (top != null) {
            throw new IllegalArgumentException();
        }
        return val;
    }

    private double push(double number) {
        return 0;
    }

    private String command;
    private StackNode top;

    // Main method of RPN calculator
    public static void main(String args[]) {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter RPN expression or \"quit\".");
            String line = in.nextLine();
            if (line.equals("quit")) {
                break;
            } else {
                RPN calc = new RPN(line);
                System.out.printf("Answer is %f\n", calc.get());
            }
        }
    }
}