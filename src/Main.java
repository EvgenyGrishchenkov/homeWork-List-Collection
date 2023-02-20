import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (true) {
            System.out.println("Выберите нужную операцию:" +
                    "\n 1 - добавить покупку в список" +
                    "\n 2 - убрать покупку из списка" +
                    "\n 3 - показать список покупок" +
                    "\n 4 - поиск по ключевому слову" +
                    "\n end - завершить работу");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            int numberOperation = Integer.parseInt(input);

            switch (numberOperation) {
                case 1:
                    addProduct(scanner, list);
                    break;
                case 2:
                    shoppingList("Список покупок:", list);

                    removeProduct(scanner, list);

                    shoppingList("Список покупок: ", list);
                    break;
                case 3:
                    shoppingList("Список покупок:", list);
                    break;

                case 4:
                    searchProduct(scanner, list);
                    break;

                default:
                    System.out.println("Такой операции нет");
            }
        }
    }

    private static void searchProduct(Scanner scanner, List<String> list) {
        System.out.println("Введите текст для поиска:");
        String query = scanner.nextLine();
        String queryLower = query.toLowerCase();
        for (int i = 0; i < list.size(); i++) {
            String item = list.get(i);
            String itemLower = item.toLowerCase();
            if (itemLower.contains(queryLower)) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }

    private static void removeProduct(Scanner scanner, List<String> list) {
        System.out.println("Какую покупку хотите удалить? Введите номер или название");
        String removeItem = scanner.nextLine();
        try {
            int numberItem = Integer.parseInt(removeItem);
            System.out.println("Покупка " + list.get(numberItem - 1) + " удалена");
            list.remove(numberItem - 1);
        } catch (NumberFormatException e) {
            for (int i = 0; i< list.size(); i++) {
                if (removeItem.equals(list.get(i))) {
                    System.out.println("Покупка " + removeItem + " удалена");
                    list.remove(i);
                }
            }
        }
    }

    private static void addProduct(Scanner scanner, List<String> list) {
        System.out.println("Какую покупку хотите добавить?");
        String addItem = scanner.nextLine();
        list.add(addItem);
        System.out.println("Итого покупок в списке " + list.size());
    }

    private static void shoppingList(String x, List<String> list) {
        System.out.println(x);
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }
}