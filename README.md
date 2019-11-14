# Week 08 Lab

## Instructions
Fork this repository into the group given to you by the instructor. Once forked, clone it to work with it in your computer.

This repository has a Gradle project under the folder named `Gradle`. Import this folder into Eclipse as a Gradle project. Write your implementation files in its `src/main/java` folder. JUnit test files are given to you in the `src/test/java` folder. Use these files to validate your implementation.

Commit and push your work as often as possible. When pushed, your project will be automatically deployed to [Web-CAT](https://web-cat.cs.vt.edu) for grading. You can push as many times as you want. The last push before the lab is due represents your final submission.

## Exercise 1
### Class: `Fibonacci`
### Method: `public static long fibonacci(long number)`
### Implementation: `Recursive`

The method receives a number and returns the fibonacci value mapping from this number. For example, given 8, the method returns 21. The method throws an *IllegalArgumentException* if the given number is negative (message "number cannot be negative").

Fibonacci values are mapped by the function *f(n) = f(n-1) + f(n-2)* for all *n > 1* and where *f(0) = 0* and *f(1) = 1*.

From this formula we can infer that initial fibonacci mappings are:

| **n**    |  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  | ... |
|----------|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| **f(n)** |  0  |  1  |  1  |  2  |  3  |  5  |  8  |  13 |  21 |  34 | ... |


## Exercise 2
### Class: `Reverse`
### Method: `public static Foo reverse(Foo foo)`
### Implementation: `Recursive`

You are given the interface **Foo** (below) used to access a sequence of values.
You do not need to implement this interface since your program will receive objects of type *Foo* directly from the test cases.

```java
public interface Foo {
  boolean isEmpty();
  Foo car();
  Foo cdr();
  Foo concat(Foo a);
}
```

The description of these methods is as follows:

- `boolean isEmpty()`: getter indicating whether there are values or not.
- `Foo car()`: getter returning a new *Foo* object with the first value in the sequence (this value is known as the **head** of the sequence). The method throws an *IndexOutOfBoundsException* if the sequence is empty.
- `Foo cdr()`: getter returning a new *Foo* object with the sequence in this *Foo* object excluding its first value (all-values-but-the-first are known as the **tail** of the sequence). If the sequence in the current *Foo* object is empty then it returns a *Foo* object with an empty sequence.
- `Foo concat(Foo a)`: method returning a new *Foo* object with the concatenation of the contents of this *Foo* object and *a*.

Implement the method `reverse` in class `Reverse` using this interface to (recursively) reverse the contents of the given *Foo* object. For example, given a *Foo* object containing {'h','e','l','l','o'} your method will return another *Foo* object containing {'o','l','l','e','h'}.


## Exercise 3
### Class: `Path`
### Method: `public static String path(int[][] array, int row, int column, int target)`
### Implementation: `Recursive`

The method receives a 2-dimensional 4x4 array of integers, and two integers indicating the zero-based row and column selected as the starting point, and the target value to find. The method will explore all adjacent (but not diagonal) neighboring places in the array and advance to the one containing the next number (that is, number + 1). The process is repeated until reaching the target number.

For example, given the array below, starting with value 1 at point (0,3) (row and column, respectively) and with the aim at finding value 7, the method will traverse from 1 (0,3) to 2 (1,3), 3 (1,2), 4 (1,1), 5 (2,1) and 6 (2,0) before reaching 7 (1,0).

<table>
<tr><td>5</td><td>5</td><td>4</td><td>1</td></tr>
<tr><td>7</td><td>4</td><td>3</td><td>2</td></tr>
<tr><td>6</td><td>5</td><td>7</td><td>3</td></tr>
<tr><td>6</td><td>6</td><td>5</td><td>4</td></tr>
</table>

The method will return a string indicating the movements from values 1 to 7 by using characters '<', '>', '^' and 'v' indicating left, right, up and down, respectively. In the example above, the method returns "v<<v<^" because the traversal from 1 at (0,3) to 7 at (1,0) required moving down-left-left-down-left-up.

All cases given to your method will be unambiguous, meaning that there will be only one path from the initial to the final values (although there may be many incomplete paths not reaching the final value).
