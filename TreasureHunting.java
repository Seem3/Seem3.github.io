import java.util.*;


public class TreasureHunting {

    static int oldX, oldY, newX, newY, realX, realY;

    public static void main(String[] args) {
        System.out.println("#######################################################");
        System.out.println("# A treasure has been hidden at a location in a 10x10 #");
        System.out.println("# gird. Guess where it is. You have 10 chances.       #");
        System.out.println("#######################################################");
         
        hunt();
    }

    public static void hunt() {
        Scanner input = new Scanner(System.in);
        newX = -1;
        newY = -1;
        int range = 11;
        realX = (int)(Math.random() * range);
        realY = (int)(Math.random() * range);

        for(int i = 1; i <= 10; i++) {
            if(newX != realX || newY != realY) {
                System.out.println("---- Round " + i + " ----");
                System.out.print("Enter your guess for X, Y: ");

                newX = realX;
                newY = realY;

                newX = input.nextInt();
                newY = input.nextInt();
                checkDistance();

                if(i >= 2) {
                    show();
                }

                if(i >= 2 && newX != realX || newY != realY) {
                    advise();
                }
                if()
            }
        }
        System.out.print("The treasure was at " + "(" + realX + "," + realY +")");
    }

    public static void show() {
        for(int y = 10; y >= 1; y--) {
            for(int x = 1; x <= 10; x++) {
                if(x == newX && y == newY) {
                    System.out.print("@");
                } else if(x == oldX && y == oldY) {
                    System.out.print("P");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println(" " + y);
        }
        System.out.println("@ = current, P = previous");
    }

    public static void checkDistance() {
        final int CLOSE = 3;
        final int FAR = 6;
        int distance;

        distance = Math.abs((newX - newY) + (realX - realY));

        if(distance >= 7) {
            System.out.println("The distance is more than 6.");
        } else if(distance >= 4 && distance <= FAR) {
            System.out.println("The distance is no more than 6.");
        } else if(distance >= 1 && distance <= CLOSE) {
            System.out.println("The distance is no more than 3.");
        } else {
            System.out.println("You have found the treasure!");
        }
    }

    public static void advise() {
        int distance;

        distance = (oldX - oldY) + (realX - realY);
        
        if(distance == 0) {
            System.out.println("The same distance");
        } else if(distance >= 1) {
            System.out.println("You are farther.");
        } else {
            System.out.println("You are closer.");
        }
    }
}
