# Postfix Calculator (Java)

**A command-line calculator that evaluates postfix (Reverse Polish Notation) expressions, built on a stack and a queue I implemented myself on top of a singly linked list.**

![Java](https://img.shields.io/badge/Java-ED8B00?logo=openjdk&logoColor=white)
![Data Structures](https://img.shields.io/badge/topic-data%20structures-blue)

Built for the Data Structures course at Smith College.

---

## How it works

In postfix notation the operator comes after its operands, so `3 4 + 2 *` means `(3 + 4) * 2 = 14`. No parentheses or precedence rules are needed, and a stack is all it takes to evaluate it:

1. The input is tokenized into a **queue** of numbers and operators.
2. Tokens are dequeued one at a time:
   - a **number** is pushed onto the **stack**;
   - an **operator** (`+ - * /`) pops the top two numbers, applies the operator, and pushes the result back.
3. When the queue is empty, the single value left on the stack is the answer.

### Error handling

The evaluator throws a clear `IllegalArgumentException` for:

- an operator with fewer than two numbers available
- division by zero
- an unsupported operator

## Data structures implemented

| Class | What it is |
|---|---|
| `SLL<T>` | Generic singly linked list with head/tail pointers, an iterator, index-based get/set/add/remove, and `splitCopy` / `splitTransfer` |
| `Stack<T>` | LIFO stack backed by `SLL` (`push` = `addFirst`, `pop` = `removeFirst`) |
| `Queue<T>` | FIFO queue backed by `SLL` (`enqueue` = `addLast`, `dequeue` = `removeFirst`) |
| `CalculatePostfix` | The evaluator and `main` entry point |

Every stack and queue operation runs in O(1) time; evaluating an expression of *n* tokens is O(n).

## Running it

```bash
javac *.java
java CalculatePostfix "3 4 + 2 *"
# Answer: 14.0
```

> **Note:** the course provided a few supporting files that are not in this repo: the `StackADT`, `QueueADT` and `NodeBasedOps` interfaces, the `NodeSL` node class and the `Tokenizer`. Add them to the same folder before compiling.

## Concepts practiced

Generics · interfaces / abstract data types · linked-list pointer manipulation · stack-based expression evaluation · exception handling

## Author

**Radiah Khan** · [Portfolio](https://radiah23.github.io)
