import java.util.Stack;

public class BrowserTabs {
    public static void main(String[] args) {
        Stack<String> openTabs = new Stack<>();
        Stack<String> closedTabs = new Stack<>();

        // Open tabs
        openTabs.push("Tab1");
        openTabs.push("Tab2");
        openTabs.push("Tab3");
        System.out.println("Open Tabs: " + openTabs);

        // Close last tab
        closedTabs.push(openTabs.pop());
        System.out.println("After Closing: Open Tabs: " + openTabs + ", Closed Tabs: " + closedTabs);

        // Restore last closed tab
        openTabs.push(closedTabs.pop());
        System.out.println("After Restore: Open Tabs: " + openTabs + ", Closed Tabs: " + closedTabs);
    }
}
