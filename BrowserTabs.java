import java.util.Scanner;
import java.util.Stack;

public class BrowserTabsInteractive {
    // ANSI color codes
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        Stack<String> openTabs = new Stack<>();
        Stack<String> closedTabs = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int tabCount = 1;

        System.out.println(CYAN + "=== Interactive Browser Tab Stack Demo ===" + RESET);

        while(true) {
            printStacks(openTabs, closedTabs);

            System.out.println("\nChoose an action:");
            System.out.println("1. Open Tab");
            System.out.println("2. Close Last Tab");
            System.out.println("3. Restore Last Closed Tab");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice) {
                case 1:
                    String tabName = "Tab" + tabCount++;
                    openTabs.push(tabName);
                    System.out.println(GREEN + "\nOpened: " + tabName + RESET);
                    break;
                case 2:
                    if(openTabs.isEmpty()) {
                        System.out.println(RED + "\nNo tabs to close!" + RESET);
                    } else {
                        String closed = openTabs.pop();
                        closedTabs.push(closed);
                        System.out.println(RED + "\nClosed: " + closed + RESET);
                    }
                    break;
                case 3:
                    if(closedTabs.isEmpty()) {
                        System.out.println(YELLOW + "\nNo closed tabs to restore!" + RESET);
                    } else {
                        String restored = closedTabs.pop();
                        openTabs.push(restored);
                        System.out.println(YELLOW + "\nRestored: " + restored + RESET);
                    }
                    break;
                case 4:
                    System.out.println(CYAN + "\nExiting demo. Goodbye!" + RESET);
                    sc.close();
                    return;
                default:
                    System.out.println(RED + "Invalid choice! Try again." + RESET);
            }
        }
    }

    // Print stacks as vertical blocks
    public static void printStacks(Stack<String> open, Stack<String> closed) {
        System.out.println("\nOpen Tabs (Top = Last Opened):");
        if(open.isEmpty()) System.out.println(GREEN + "| Empty |" + RESET);
        else {
            for(int i=open.size()-1; i>=0; i--) {
                System.out.println(GREEN + "| " + open.get(i) + " |" + RESET);
            }
        }

        System.out.println("\nClosed Tabs (Top = Last Closed):");
        if(closed.isEmpty()) System.out.println(RED + "| Empty |" + RESET);
        else {
            for(int i=closed.size()-1; i>=0; i--) {
                System.out.println(RED + "| " + closed.get(i) + " |" + RESET);
            }
        }

        System.out.println("----------------------------------------");
    }
}
