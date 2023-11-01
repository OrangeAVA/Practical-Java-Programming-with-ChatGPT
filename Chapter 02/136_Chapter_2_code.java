// UserService class responsible for user-related operations
public class UserService {
public void registerUser(String username, String password) {
// logic for registering a user
}

public void authenticateUser(String username, String password) {
// logic for authenticating a user
}

public void resetPassword(String username) {
// logic for resetting a user's password
}

// other user-related methods...
}

// EmailService class responsible for sending emails
public class EmailService {
public void sendEmail(String recipient, String message) {
// logic for sending an email
}

// other email-related methods...
}

//--------------------------------------
//--------------------------------------
// Shape interface representing a geometric shape
public interface Shape {
double calculateArea();
}

// Rectangle class implementing the Shape interface
   public class Rectangle implements Shape {
private double width;
private double height;

public Rectangle(double width, double height) {
this.width = width;
this.height = height;
}

public double getWidth() {
return width;
}

public double getHeight() {
return height;
}

public double calculateArea() {
return width * height;
}
   }

// Circle class implementing the Shape interface
public class Circle implements Shape {
private double radius;

public Circle(double radius) {
this.radius = radius;
}

public double getRadius() {
return radius;
}

public double calculateArea() {
return Math.PI * radius * radius;
}
}

// AreaCalculator class responsible for calculating the total area of shapes
public class AreaCalculator {
public double calculateTotalArea(Shape[] shapes) {
double totalArea = 0;
for (Shape shape : shapes) {
totalArea += shape.calculateArea();
}
return totalArea;
}
}
//--------------------------------------
//--------------------------------------
// Shape interface representing a geometric shape
public interface Shape {
double calculateArea();
}

// Rectangle class implementing the Shape interface
public class Rectangle implements Shape {
private double width;
private double height;

public Rectangle(double width, double height) {
this.width = width;
this.height = height;
}

public double getWidth() {
return width;
}

public void setWidth(double width) {
this.width = width;
}

public double getHeight() {
return height;
}

public void setHeight(double height) {
this.height = height;
}

public double calculateArea() {
return width * height;
}
}

// Square class extending the Rectangle class
public class Square extends Rectangle {
public Square(double sideLength) {
super(sideLength, sideLength);
}

@Override
public void setWidth(double width) {
super.setWidth(width);
super.setHeight(width);
}

@Override
public void setHeight(double height) {
super.setWidth(height);
super.setHeight(height);
}
}

// AreaCalculator class responsible for calculating the total area of shapes
public class AreaCalculator {
public double calculateTotalArea(Shape[] shapes) {
double totalArea = 0;
for (Shape shape : shapes) {
totalArea += shape.calculateArea();
}
return totalArea;
}
}
//--------------------------------------
//--------------------------------------
// Interface Segregation Principle Violation

// Suppose we have a monolithic interface that contains multiple methods.
interface Worker {
    void work();
    void eat();
    void sleep();
}

class Employee implements Worker {
    @Override
    public void work() {
        System.out.println("Employee is working.");
    }

    @Override
    public void eat() {
        System.out.println("Employee is eating.");
    }

    @Override
    public void sleep() {
        System.out.println("Employee is sleeping.");
    }
}

class Robot implements Worker {
    @Override
    public void work() {
        System.out.println("Robot is working.");
    }

    @Override
    public void eat() {
        // Robots don't eat, so this method is irrelevant and violates ISP.
        throw new UnsupportedOperationException("Robots don't eat.");
    }

    @Override
    public void sleep() {
        // Robots don't sleep, so this method is irrelevant and violates ISP.
        throw new UnsupportedOperationException("Robots don't sleep.");
    }
}

public class Main {
    public static void main(String[] args) {
        Worker employee = new Employee();
        employee.work();
        employee.eat();
        employee.sleep();

        Worker robot = new Robot();
        robot.work();
        robot.eat();  // This call doesn't make sense for a Robot and may cause errors.
        robot.sleep(); // This call doesn't make sense for a Robot and may cause errors.
    }
}
//--------------------------------------
//--------------------------------------
// Dependency Inversion Principle Example

// High-level module that depends on an abstraction.
class LightBulb {
    void turnOn() {
        System.out.println("LightBulb: Bulb turned on.");
    }

    void turnOff() {
        System.out.println("LightBulb: Bulb turned off.");
    }
}

// Another high-level module that also depends on the same abstraction.
class Switch {
    private final Switchable device;

    Switch(Switchable device) {
        this.device = device;
    }

    void turnOn() {
        System.out.println("Switch: Turning on...");
        device.turnOn();
    }

    void turnOff() {
        System.out.println("Switch: Turning off...");
        device.turnOff();
    }
}

// Abstraction (interface) that both high-level modules depend on.
interface Switchable {
    void turnOn();
    void turnOff();
}

// Low-level module that implements the abstraction.
class Fan implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("Fan: Fan turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Fan: Fan turned off.");
    }
}

public class Main {
    public static void main(String[] args) {
        Switchable fan = new Fan();

        Switch fanSwitch = new Switch(fan);
        fanSwitch.turnOn();
        fanSwitch.turnOff();

        LightBulb bulb = new LightBulb();

        Switch bulbSwitch = new Switch(bulb);
        bulbSwitch.turnOn();
        bulbSwitch.turnOff();
    }
}
