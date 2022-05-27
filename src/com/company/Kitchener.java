package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Kitchener extends Teacher {
    private String name;
    private String surname;
    private String patronymic;
    private String type;
    private int age;
    private int experience;


    Scanner sc = new Scanner(System.in);

    Kitchener(String name, String surname, String patronymic, String type, int age, int experience) {
        super(name, surname, patronymic, age, type, experience);

        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.type = type;
        this.age = age;
        this.experience = experience;

    }

    @Override
    int testForEmployee(String sub) throws InterruptedException {
        if(sub.equals("Кухар")) {

            if(!type.equals(sub)) {
                System.out.println("Виберіть тест згідно вашої посади!");
                System.out.println("Введіть тест: ");
                sub = sc.nextLine();
                return testForEmployee(sub);
            }

            int counter = 0;
            String answer;

            System.out.println("\nТестування на посаду '" + type + "' " + "П.І.Б - " + surname + " " + name + " " + patronymic + "\n");

            System.out.print("Перше запитання. Про що йде мова?\n\n\t Базовий соус на основі ру та молока.\n\t Використовується як соус до багатьох страв європейської кухні,\n\t а також основи для різних соусів.\n\t Застосовується, зокрема, при приготуванні суфле та лазаньї: ");
            answer = sc.nextLine();

            System.out.println();

            if(answer.equals("Бешамель")) counter++;

            System.out.print("Друге запитання. Головний інгредієнт борщу?: ");
            answer = sc.nextLine();

            if(answer.equals("Буряк")) counter++;

            System.out.print("Третє запитання. Про що йде мова? Італійский вершковий сир: ");
            answer = sc.nextLine();

            if(answer.equals("Маскарпоне")) counter++;

            System.out.print("Четверте запитання. Скільки градусів за цельсієм потрібно для випічки хлібу?: ");
            answer = sc.nextLine();

            if(answer.equals("220")) counter++;

            System.out.print("П'яте запитання. Який тип м'яса тяжче приготувати?: ");
            answer = sc.nextLine();

            if(answer.equals("Телятина")) counter++;

            if(counter <= 2) {
                System.out.println("На посаду з " + type + ". НЕ ПРИЙНЯТО.");
                return counter;
            } else {
                try(FileWriter writer = new FileWriter("Employees.txt", true))
                {
                    // запис всього рядку
                    writer.append("Прийнятий новий робітник на посаду " + "'" + type + "'" + " - " + surname + " " + name + " " + patronymic + " " + age + " років. Досвід " + experience + " років" + "\n");
                    writer.flush();

                    System.out.println("\nВас прийнято на роботу! Тест зданий!");
                }
                catch(IOException ex){

                    System.out.println(ex.getMessage());
                }
                return counter;
            }


        } else if(sub.equals("Кондитер")) {
            if(!type.equals(sub)) {
                System.out.println("Виберіть тест з вашого предмету!");
                System.out.print("Введіть предмет: ");
                sub = sc.nextLine();
                System.out.println();
                return testForEmployee(sub);
            }

            int counter = 0;
            String answer;

            System.out.println("Тестування на посаду '" + type + "' " + "П.І.Б - " + surname + " " + name + " " + patronymic + "\n");

            System.out.print("Перше питання. Часто використовуванний елемент у кондитерстві: ");
            answer = sc.nextLine();

            if(answer.equals("Шоколад")) counter++;

            System.out.print("Друге питання. Про що йде мова?\n\t Кондитерський крем, робиться з молока,\n\t вершків та води, яєць, цукру, борошна або крохмалю: ");
            answer = sc.nextLine();

            if(answer.equals("Заварний крем")) counter++;

            System.out.println();
            System.out.print("Третє питання. Про що йде мова?\n\tВикористовують для намазки та прикраси поверхні тортів та тістечок,\n\tа також для наповнення трубочок та згорнутих у рулон вафель.\n\tЦі креми внаслідок ніжної та пишної структури непридатні для прошарку,\n\tтобто склеювання випечених пластів: ");
            answer = sc.nextLine();

            if(answer.equals("Білковий крем")) counter++;

            System.out.println();
            System.out.print("Четверте питання. Як називаються рівні у торті: ");
            answer = sc.nextLine();

            if(answer.equals("Коржі")) counter++;

            System.out.print("П'яте питання. Правда, що кондитери додають сіль у виріб для посилення смаку?: ");
            answer = sc.nextLine();

            if(answer.equals("Так")) counter++;

            if(counter <= 2) {
                System.out.println("На посаду " + type + ". НЕ ПРИЙНЯТО.");
                return counter;
            } else {
                try(FileWriter writer = new FileWriter("Employees.txt", true))
                {
                    // запис всього рядку
                    writer.append("Прийнятий новий робітник на посаду " + "'" + type + "'" + " - " + surname + " " + name + " " + patronymic + " " + age + " років. Досвід " + experience + " років" + "\n");
                    writer.flush();

                    System.out.println("\nВас прийнято на роботу! Тест зданий!");
                }
                catch(IOException ex){

                    System.out.println(ex.getMessage());
                }
                return counter;
            }

        } else {
            System.out.println("Такого тесту немає!");
            System.out.print("Введіть вашу посаду для тесту: ");
            sub = sc.nextLine();
            System.out.println();
            testForEmployee(sub);
        }
        return 0;
    }

    void getInfo() {
        System.out.println("\nІм'я - " + name);
        System.out.println("Прізвище - " + surname);
        System.out.println("По батькові - " + patronymic);
        System.out.println("Вік - " + age);
        System.out.println("Посада - " + type);
        System.out.println("Досвід - " + experience);
    }

    void setInfo(String name, String surname) throws FileNotFoundException {
        File doc = new File("Employees.txt");
        Scanner obj = new Scanner(doc);
        String info = "";
        while (obj.hasNextLine()) {
            info += obj.nextLine() + "\n";
        }

        info = info.replace(this.name, name);
        info = info.replace(this.surname, surname);

        try(FileWriter writer = new FileWriter("Employees.txt", false))
        {
            // запис всього рядку
            writer.append(info);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    double appointment(double time, String food) {
        try(FileWriter writer = new FileWriter("Appointments.txt", true))
        {
            // запис всього рядку
            writer.append("Замовлення до робітника - Кухар. "  + " На " + time + " годину. " + food + "\n");
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return time;
    }

    void showAppointmentsK() throws FileNotFoundException {
        File doc = new File("Appointments.txt");
        Scanner obj = new Scanner(doc);
        String info = "";
        while (obj.hasNextLine()) {
            info = obj.nextLine();
            int i = 1;
            while (obj.hasNextLine()) {
                info += i + ". " + obj.nextLine() + "\n";
                i++;
            }
            System.out.println();
            System.out.println(info);
        }
    }
}
