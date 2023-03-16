import java.util.ArrayList;
import java.util.Scanner;

class Item {
    private String name;
    private int quantity;
    private double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Inventory {
    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(String name) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item.getName().equals(name)) {
                items.remove(i);
                return;
            }
        }
    }

    public void updateQuantity(String name, int quantity) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item.getName().equals(name)) {
                item.setQuantity(quantity);
                return;
            }
        }
    }

    public void updatePrice(String name, double price) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item.getName().equals(name)) {
                item.setPrice(price);
                return;
            }
        }
    }

    public void displayInventory() {
        System.out.println("Name\tQuantity\tPrice");
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.println(item.getName() + "\t" + item.getQuantity() + "\t\t" + item.getPrice());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Update quantity");
            System.out.println("4. Update price");
            System.out.println("5. Display inventory");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.next();

                    System.out.print("Enter item quantity: ");
                    int quantity = scanner.nextInt();

                    System.out.print("Enter item price: ");
                    double price = scanner.nextDouble();

                    Item item = new Item(name, quantity, price);
                    inventory.addItem(item);

                    System.out.println("Item added successfully!");
                    break;

                case 2:
                    System.out.print("Enter item name: ");
                    name = scanner.next();
                    inventory.removeItem(name);
                    System.out.println("Item removed successfully!");
                    break;

                case 3:
                    System.out.print("Enter item name: ");
                    name = scanner.next();

                    System.out.print("Enter new quantity: ");
                    quantity = scanner.nextInt();

                    inventory.updateQuantity(name, quantity);
                    System.out.println("Quantity updated successfully!");
                    break;

                case 4:
                    System.out.print("Enter item name: ");
                    name = scanner.next();

                    System.out.print("Enter new price: ");
                    price = scanner.nextDouble();

                    inventory.updatePrice(name, price);
                    System.out.println("Price updated successfully!");
                    break;

                case 5:
                    inventory.displayInventory();
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }}}}

