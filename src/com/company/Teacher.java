package com.company;

import java.io.*;
import java.util.Scanner;

public class Teacher {
    private String name;
    private String surname;
    private String patronymic;
    private int age;
    private String subject;
    private int experience;

    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_GREEN = "\u001B[32m";
    private final String ANSI_YELLOW = "\u001B[33m";
    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_WHITE = "\u001B[37m";


    Scanner sc = new Scanner(System.in);

    Teacher(String name, String surname, String patronymic, int age, String subject, int experience) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        this.subject = subject;
        this.experience = experience;
    }

    int testForEmployee(String sub) throws InterruptedException {
        if(sub.equals("Історія")) {

            if(!subject.equals(sub)) {
                System.out.println(ANSI_YELLOW + "Виберіть тест згідно вашого предмету!");
                System.out.println("Введіть предмет: ");
                sub = sc.nextLine();
                return testForEmployee(sub);
            }

            int counter = 0;
            String answer;

            System.out.println(ANSI_YELLOW + "\nТестування на посаду вчителя з предмету '" + subject + "' " + "П.І.Б - " + surname + " " + name + " " + patronymic + "\n");

            System.out.print("Перше запитання. У якому році розпочалась перша світова війна?: ");
            answer = sc.nextLine();

            if(answer.equals("1914")) counter++;

            System.out.print("Друге запитання. У якому році закінчилась перша світова війна?: ");
            answer = sc.nextLine();

            if(answer.equals("1918")) counter++;

            System.out.print("Третє запитання. Що очолював Степан Бандера?: ");
            answer = sc.nextLine();

            if(answer.equals("ОУН")) counter++;

            System.out.print("Четверте запитання. Хто був першим президентом України?: ");
            answer = sc.nextLine();

            if(answer.equals("Леонід Кравчук")) counter++;

            System.out.print("П'яте запитання. Ким був В'ячеслав Чорновіл?: ");
            answer = sc.nextLine();

            if(answer.equals("Борцем за незалежність України")) counter++;

            if(counter <= 2) {
                System.out.println("На посаду вчителя з " + subject + ". НЕ ПРИЙНЯТО.");
                return counter;
            } else {
                try(FileWriter writer = new FileWriter("Employees.txt", true))
                {
                    // запис всього рядку
                    writer.append("Прийнятий новий вчитель з предмету " + "'" + subject + "'" + " - " + surname + " " + name + " " + patronymic  + " " + age + " років. Досвід " + experience + " років" + "\n");
                    writer.flush();

                    System.out.println("\nВас прийнято на роботу! Тест зданий!" + ANSI_RESET);
                }
                catch(IOException ex){

                    System.out.println(ex.getMessage());
                }
                return counter;
            }


        } else if(sub.equals("English")) {
            if(!subject.equals(sub)) {
                System.out.println(ANSI_RED + "Виберіть тест з вашого предмету!");
                System.out.print("Введіть предмет: " + ANSI_RESET);
                sub = sc.nextLine();
                System.out.println();
                return testForEmployee(sub);
            }

            int counter = 0;
            String answer;

            System.out.println(ANSI_PURPLE + "Тest for Teacher of English '" + subject + "' " + "initials - " + surname + " " + name + " " + patronymic + "\n");

            System.out.print("First question. a apple/an apple?: ");
            answer = sc.nextLine();

            if(answer.equals("2")) counter++;

            System.out.print("Second question. Do you have a dog?/Does you have a dog?: ");
            answer = sc.nextLine();

            if(answer.equals("1")) counter++;

            System.out.print("Third question. Check, is correct? - If you wish to be loved, love!: ");
            answer = sc.nextLine();

            if(answer.equals("Yes")) counter++;

            System.out.print("Fourth question, how say correct?. 1. Well, no ones perfect. 2. Well, nobody are perfect. 3. Well, nobody's perfects. 4. Well, nobody's perfect.: ");
            answer = sc.nextLine();

            if(answer.equals("4")) counter++;

            System.out.print("Fifth question. My father is ______ yours (Phrases: as strong, the best, stronger than, the better than): " + ANSI_RESET);
            answer = sc.nextLine();

            if(answer.equals("stronger than")) counter++;

            if(counter <= 2) {
                System.out.println(ANSI_RED + "На посаду вчителя з " + subject + ". НЕ ПРИЙНЯТО." + ANSI_RESET);
                return counter;
            } else {
                try(FileWriter writer = new FileWriter("Employees.txt", true))
                {
                    // запис всього рядку
                    writer.append("Прийнятий новий вчитель з предмету " + "'" + subject + "'" + " - " + surname + " " + name + " " + patronymic + " " + age + " років. Досвід " + experience + "років" + "\n");
                    writer.flush();

                    System.out.println(ANSI_WHITE + "\nВас прийнято на роботу! Тест зданий!" + ANSI_WHITE);
                }
                catch(IOException ex){

                    System.out.println(ex.getMessage());
                }
                return counter;
            }

        } else {
            System.out.println(ANSI_RED + "Такого тесту немає!");
            Thread.sleep(1000);
            System.out.println("Введіть ваш тест: " + ANSI_RESET);
            sub = sc.nextLine();
            testForEmployee(sub);
        }
        return 0;
    }

    void getInfo() {
        System.out.println(ANSI_GREEN + "Ім'я - " + name);
        System.out.println("Прізвище - " + surname);
        System.out.println("По батькові - " + patronymic);
        System.out.println("Вік - " + age);
        System.out.println("Предмет - " + subject);
        System.out.println("Досвід - " + experience + "\n" + ANSI_RESET);
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
            writer.append("Запис учня до вчителя з предмету - " + subject + ". На " + time + " годину" + "\n");
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return time;
    }

    void showAppointmentsT() throws FileNotFoundException {
        File doc = new File("Appointments.txt");
        Scanner obj = new Scanner(doc);
        String info = "";
        int i = 1;
        while (obj.hasNextLine()) {
            info += i + ". " + obj.nextLine() + "\n";
            i++;
        }
        System.out.println();
        System.out.println(info);
    }
}
