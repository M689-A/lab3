package kaif;

public class task1 {
    
    // Non-static Table class
    class Table {
        void printTable(int n) { // method not synchronized
            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    // Thread 1 class
    class MyThread1 extends Thread {
        Table t;

        MyThread1(Table t) {
            this.t = t;
        }

        public void run() {
            t.printTable(5);
        }
    }

    // Thread 2 class
    class MyThread2 extends Thread {
        Table t;

        MyThread2(Table t) {
            this.t = t;
        }

        public void run() {
            t.printTable(100);
        }
    }

    // Top-level TestThread class with main method
    public static void main(String args[]) {
        // Create an instance of the outer class 'task1' to access non-static Table
        task1 outerClassInstance = new task1();
        Table obj = outerClassInstance.new Table(); // Create an instance of the non-static Table class

        // Create instances of threads
        MyThread1 t1 = outerClassInstance.new MyThread1(obj); // Thread for table of 5
        MyThread2 t2 = outerClassInstance.new MyThread2(obj); // Thread for table of 100

        // Start the threads
        t1.start();
        t2.start();
    }
}
