package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Doctor extends Kitchener {
    private String name;
    private String surname;
    private String patronymic;
    private int age;
    private String type;
    private int experience;

    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_CYAN = "\u001B[36m";

    Scanner sc = new Scanner(System.in);

    Doctor(String name, String surname, String patronymic, int age, String type, int experience) {
        super(name, surname, patronymic, type, age, experience);
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        this.type = type;
        this.experience = experience;
    }
    ///
    @Override
    int testForEmployee(String sub) throws InterruptedException {
        if(sub.equals("Терапевт")) {

            if(!type.equals(sub)) {
                System.out.println(ANSI_RED + "Виберіть тест згідно вашої посади!");
                System.out.println("Введіть тест: ");
                sub = sc.nextLine();
                return testForEmployee(sub);
            }

            int counter = 0;
            String answer;

            System.out.println(ANSI_CYAN + "\nТестування на посаду '" + type + "' " + "П.І.Б - " + surname + " " + name + " " + patronymic + "\n");

            System.out.print("Перше запитання. Хвороба, якій характерно запалення легень: ");
            answer = sc.nextLine();

            if(answer.equals("Пневмонія")) counter++;

            System.out.print("Друге запитання. Почервоніння у формі кіл, червоного кольору, запалення. У шлунку?: ");
            answer = sc.nextLine();

            if(answer.equals("Ерозії")) counter++;

            System.out.print("Третє запитання. Запальний процес, що охоплює всю область горла: ");
            answer = sc.nextLine();

            if(answer.equals("Ларингіт")) counter++;

            System.out.print("Четверте запитання. Назва запалення вуха?: ");
            answer = sc.nextLine();

            if(answer.equals("Отит")) counter++;

            System.out.print("П'яте запитання. Переважне ураження серця і суглобів, назва хвороби?: ");
            answer = sc.nextLine();

            if(answer.equals("Ревматизм")) counter++;

            if(counter <= 2) {
                System.out.println("На посаду з " + type + ". НЕ ПРИЙНЯТО.");
                return counter;
            } else {
                try(FileWriter writer = new FileWriter("Employees.txt", true))
                {
                    // запис всього рядку
                    writer.append("Прийнятий новий вчитель з предмету " + "'" + type + "'" + " - " + surname + " " + name + " " + patronymic + " " + age + " років. Досвід " + experience + " років" + "\n");
                    writer.flush();

                    System.out.println("\nВас прийнято на роботу! Тест зданий!");
                }
                catch(IOException ex){

                    System.out.println(ex.getMessage());
                }
                return counter;
            }


        } else if(sub.equals("Психіатр")) {
            if(!type.equals(sub)) {
                System.out.println("Виберіть тест з вашого предмету!");
                System.out.print("Введіть предмет: ");
                sub = sc.nextLine();
                System.out.println();
                return testForEmployee(sub);
            }

            int counter = 0;
            String answer;

            System.out.println("\nТестування на посаду '" + type + "' " + "П.І.Б - " + surname + " " + name + " " + patronymic + "\n");

            System.out.print("Перше питання. Назва хвороби якій характерно бачення галлюцинацій таких як: зорових і слухових: ");
            answer = sc.nextLine();

            if(answer.equals("Параноїдна шизофренія")) counter++;

            System.out.print("Друге питання. Розлад при якому людина робить постійні нав'язливі дії, інакше сильний дискомфорт: ");
            answer = sc.nextLine();

            if(answer.equals("ОКР")) counter++;

            System.out.print("Третє питання. Ідеї переслідування, страх: ");
            answer = sc.nextLine();

            if(answer.equals("Параноя")) counter++;

            System.out.print("Четверте питання. Порушення розвитку головного мозку і характеризується вродженим та всебічним дефіцитом соціальної взаємодії та спілкування: ");
            answer = sc.nextLine();

            if(answer.equals("Аутизм")) counter++;

            System.out.print("П'яте питання. Серотонін це: ");
            answer = sc.nextLine();

            if(answer.equals("Нейромедіатор")) counter++;

            if(counter <= 2) {
                System.out.println("На посаду " + type + ". НЕ ПРИЙНЯТО.");
                return counter;
            } else {
                try(FileWriter writer = new FileWriter("Employees.txt", true))
                {
                    // запис всього рядку
                    writer.append("Прийнятий новий вчитель з предмету " + "'" + type + "'" + " - " + surname + " " + name + " " + patronymic + " " + age + " років. Досвід " + experience + " років" + "\n");
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
        System.out.println("Ім'я - " + name);
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

    double appointment(double time) {
        try(FileWriter writer = new FileWriter("Appointments.txt", true))
        {
            // запис всього рядку
            writer.append("Запис пацієнта до лікаря - " + type + ". На " + time + " годину" + "\n");
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return time;
    }

    void showAppointmentsD() throws FileNotFoundException {
        File doc = new File("Appointments.txt");
        Scanner obj = new Scanner(doc);
        String info = "";
        while (obj.hasNextLine()) {
            info = obj.nextLine();
            int i = 1;
            if(info.contains("Терапевт") || info.contains("Психіатр")) {
                System.out.println(i + ". " + info);
                i++;
            }
        }
    }
}
