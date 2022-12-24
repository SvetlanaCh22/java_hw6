// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

// Чубченко Светлана

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class main {

    static List<Laptop> shop; // список с ноутбуками

    public static void main(String[] args) {

        // создаем каталог ноутбуков на базе класса Laptop
        shop = new LinkedList<Laptop>();

        // заполняем каталог
        shop.add(new Laptop(1, 2, 128, "Windows XP", "черный"));
        shop.add(new Laptop(1, 4, 256, "Windows 7", "белый"));
        shop.add(new Laptop(1, 16, 512, "Windows 10", "серебристый"));
        shop.add(new Laptop(1, 32, 1024, "Windows 11", "черный"));

        // задаем константу ответа в случае, если искомый вариант не найден
        final String no_laptops = "\nК сожалению, у нас таких ноутбуков нет :(\n";

        // задаем сканер
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int choice;

        // меню выводим циклично
        while (true) {
            System.out.println("Добро пожаловать в магазин ноутбуков!");
            System.out.println("1 - поиск по объему оперативной памяти");
            System.out.println("2 - поиск по объему встроенного накопителя");
            System.out.println("3 - поиск по используемой операционной системе");
            System.out.println("4 - выход");

            // выбранный пункт меню
            choice = sc.nextInt();
            System.out.println();
            int n = 0; // больше ноля если что-то нашли
            StringBuilder founded = new StringBuilder(); // найденные ноутбуки
            if(choice == 1){
                System.out.println("Какой минимальный объем оперативной памяти (в Гб) Вам требуется?");
                int ram = sc.nextInt();
                for (Laptop laptop : shop) {
                    if (laptop.ram >= ram) {
                        founded.append(laptop.toString()).append("\n");
                        n++;
                    }
                }
            }else if(choice == 2){
                System.out.println("Какой минимальный объем встроенного накопителя (в Гб) Вам требуется?");
                int hdd = sc.nextInt();
                for (Laptop laptop : shop) {
                    if (laptop.hdd >= hdd) {
                        founded.append(laptop.toString()).append("\n");
                        n++;
                    }
                }
            }else if(choice == 3){
                System.out.println("Какая операционная система для Вас предпочтительна?");
                String os = sc2.nextLine();
                for (Laptop laptop : shop) {
                    if (os.equals(laptop.os)) {
                        founded.append(laptop.toString()).append("\n");
                        n++;
                    }
                }
            }else if(choice == 4){
                break; // выход из меню
            }
            if(n==0) {
                System.out.println(no_laptops); // ничего не нашли
            } else {
                System.out.println("\nНайдены следующие варианты:\n\n" + founded); // выводим найденные ноутбуки
            }
        }
        sc.close();
        sc2.close();
    }

}

// класс ноутбука
class Laptop {
    // характеристики ноутбука
    int id;
    int ram;
    int hdd;
    String os;
    String color;

    // конструктор класса
    public Laptop(int id, int ram, int ssd, String os, String color){
        this.id = id;
        this.ram = ram;
        this.hdd = ssd;
        this.os = os;
        this.color = color;
    }

    // вывод всех полей в одну строку
    public String toString() {
        return String.format("id: %d, ram: %d ГБ, ssd: %d ГБ, OS: %s, color: %s", id, ram, hdd, os, color);
    }

}

