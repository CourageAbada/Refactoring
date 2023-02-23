# Refactoring
Reverse-Polish Notation (RPN) Calculator
This code implements an RPN calculator in Java. RPN is a mathematical notation in which operators follow the operands.

The program takes a string as input and evaluates it as an RPN expression. The supported operators are +, -, *, /, and ^ (exponentiation).

Usage
To use the calculator, simply run the main method of the RPN class. The program will prompt you to enter an RPN expression. Type in the expression and hit enter. The program will then evaluate the expression and print the result.

To exit the program, type "quit" at the prompt.

Class Structure
The code contains two classes: stackNode and RPN.

stackNode Class
stackNode is a class that defines a node in a stack data structure. It has two public attributes: data and underneath. data holds the value of the node, while underneath points to the node below it in the stack.

RPN Class
RPN is the main class of the program. It has the following public methods:

into(double newData): adds a new element to the top of the stack.
pull(): removes and returns the top element from the stack.
get(): evaluates the RPN expression and returns the result.
The class also has a private method push(double number) which is called by get() to add elements to the stack.

The main method of the RPN class is used to run the calculator. It prompts the user for input and evaluates the input as an RPN expression until the user types "quit".
