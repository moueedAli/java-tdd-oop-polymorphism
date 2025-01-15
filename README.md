# Object-oriented Programming - Polymorphism

## Learning Objectives
- Describe polymorphism as being able to use different things in the same way
- Explain how polymorphism can be used to build simpler code
- Use polymorphism to simplify code

## Set up instructions
- Fork this repository and clone the forked version to your machine
- Open the root directory of the project in IntelliJ

## Introduction

Polymorphism is the ability to use different classes in the same way. You were already using polymorphism in your previous *dependency injection with interfaces* exercise, now we'll take a closer look at what it really is.

Here's a class that moves a car a certain number of metres:

```java
class Mover {
    public void move(Car car, int metres) {
        car.accelerate(metres);
    }
}
```

If we want to reuse this class for different means of travel, we'd probably have to do something like the below, right?

```java
class Mover {
    public void move(Car car, int metres) {
        car.accelerate(metres);
    }
    
    public void move(Plane plane, int metres) {
        plane.fly(metres);
    }
    
    public void move(Skateboard skateboard, int metres) {
        skateboard.skate(metres);
    }
}
```

This code is not polymorphic. It's performing the same sort of logic on different classes but requires a different implementation for each of them. Using an interface, we could vastly improve this code to a single method:

```java
interface Vehicle {
    void move(int metres);
}

class Mover {
    public void move(Vehicle vehicle, int metres) {
        vehicle.move(metres);
    }
}
```

As long as our `Car`, `Plane` and `Skateboard` all implement the `Vehicle` interface, we can pass that class into the `Mover`'s `move` method without any issues! Much cleaner.

To demonstrate its true power, consider something that you will have encountered in earlier exercises:

```java
class Program {
    public static void main() {
        List<int> favouriteNumbers = new ArrayList<>();
        Map<Character, Integer> letterScores = new HashMap<>();
    }
}
```

Both `List` and `Map` are interfaces, `ArrayList` and `HashMap` are specific concrete implementations of those interfaces. There are different types of lists and maps, but they all share the same methods! Some have more methods than are defined on the interface they implement, but they all *at least* have the methods defined on the interface.

## Exercise

There are a number of classes inside the `./src/main/java/com/booleanuk/core` directory, and tests in the `./src/test/java/com/booleanuk/core` directory.

Your task is to refactor the classes, especially the `Basket` class, to be simpler using polymorphism.

The Basket class must
- Contain only one `add` method
- Contain no more than 1 loop in the `getTotal` and `isInBasket` methods

The tests are already passing. You must not change the existing tests (though you can add more if you like). The tests should still pass after implementing your changes.

## Next steps

Now that you've learned about dependency injection and polymorphism, introduce these concepts into your Bob's Bagels OOP exercise. You will need to refactor your existing code and change your tests to accommodate these changes.

Although it may be tough, you should see the amount of code in your exercise reduce substantially as an end result.

## Test Output

![](./assets/run-a-test.PNG)

When you run a test, it's either going to pass or fail. When it fails, you'll be presented with a big red stream of text. This is called a stack trace and, though intimidating, does contain some useful information.

One of the core skills of a developer is debugging stack traces like this. The stack trace details in which classes & files the failure happened, and gives you a line number at the end. Most of the lines in the stack trace are irrelevant most of the time, you want to try and identify the files that you're actually working with.

In the sample screenshot below, we've tried to complete the first step of the exercise but provided an invalid value. Then we run the test associated with it and we see a big red stack trace, a test failure.

At the top, we see `expected: <32> but was: <33>`. This means the test expected the value to be 32, but the value the student provided was 33. We can see this in the code snippets at the top of the screenshot.

In the stack trace itself, we see this line: `at app//com.booleanuk.core.BasketTest.shouldBeAged32(ExerciseTest.java:20)`. This is helpful! This tells us the exact line in the ExerciseTest.java file (line 20) where the failure happened, as well as the method name (shouldBeAged32), helping us to identify where the issue began. This is the kind of thing you need to look for; a relevant file name, method name, class name and line number to give you a good starting point for debugging.

![](./assets/test-failure.PNG)
