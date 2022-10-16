import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> shoppingList = new ArrayList<>();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите операцию: ");
            System.out.println("1.Добавить");
            System.out.println("2.Показать");
            System.out.println("3.Удалить");
            System.out.println("4.Найти");
            int input = scanner.nextInt();

            if (input == 1) {
                Scanner scannerAdd = new Scanner(System.in);
                System.out.println("Какую покупку хотите добавить?");
                String inputText = scannerAdd.nextLine();
                shoppingList.add(inputText);
                System.out.println("Итого в списке покупок: " + shoppingList.size());
            } else if (input == 2) {
                System.out.println("Список покупок:");
                for (int i = 0; i < shoppingList.size(); i++) {
                    System.out.println((i + 1) + "." + shoppingList.get(i));
                }
            } else if (input == 3) {
                System.out.println("Какую покупку вы хотите удалить?");
                for (int k = 0; k < shoppingList.size(); k++) {
                    Scanner scannerDel = new Scanner(System.in);
                    String del = scannerDel.nextLine(); // 2   Хлеб
                    String replacmentDel = del.replaceAll("[0123456789]", "");
                    if (replacmentDel == "") {
                        int delInt = Integer.parseInt(del);
                        System.out.println("Покупка " + shoppingList.get(delInt - 1) + " удалена. Текущий список покупок: ");
                        shoppingList.remove(delInt - 1);
                        for (int i = 0; k < shoppingList.size(); k++) {
                            System.out.println((k + 1) + "." + shoppingList.get(i));
                        }
                    } else {
                        System.out.println("Покупка " + shoppingList.get(shoppingList.indexOf(del)) + " удалена. Текущий список покупок: ");
                        shoppingList.remove(del);
                        for (int j = 0; j < shoppingList.size(); j++) {
                            System.out.println((j + 1) + "." + shoppingList.get(j));
                        }
                    }
                    continue;
                }
            } else if (input == 4) {
                Scanner scannerToFind = new Scanner(System.in);
                System.out.println("Введите текст для поиска:");
                String find = scannerToFind.nextLine();
                System.out.println("Найдено: ");
                for (int i = 0; i < shoppingList.size(); i++) {
                    String queryLower = find.toLowerCase();
                    String itemLower = shoppingList.get(i).toLowerCase();
                    if (itemLower.contains(queryLower)) {
                        System.out.println((i + 1) + "." + shoppingList.get(i));
                    }
                }
            } else {
                System.out.println("Такой операции нет!");
                continue;
            }
        }



    }
}
