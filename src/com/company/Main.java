package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main extends Kitchener {

    Main(String name, String surname, String patronymic, String type, int age, int experience) {
        super(name, surname, patronymic, type, age, experience);
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        Teacher teacher = new Teacher("Дмитро", "Тетерів", "Олександрович",  37,"Історія", 7);
        teacher.getInfo();
        int point = teacher.testForEmployee("Історія");
        if(point > 2){
            teacher.appointment(19.45);
            teacher.showAppointmentsT();
        }

        Kitchener kitchener = new Main("Сергій", "Лазаров", "Олегович", "Кухар", 54, 14);
        kitchener.getInfo();
        int point_2 = kitchener.testForEmployee("Кухар");
        if(point_2 > 2) {
            kitchener.appointment(10.45, "Холодець");
            kitchener.showAppointmentsK();
        }

        Doctor doctor = new Doctor("Даніель", "Світлий", "Андрійович", 25, "Психіатр", 5);
        doctor.getInfo();
        int point_3 = doctor.testForEmployee("Психіатр");

        if(point_3 > 2) {
            doctor.appointment(15.35);
            doctor.showAppointmentsD();
        }

        if(point > 2) {
            teacher.setInfo("Андрій", "Вічний");
        }

        AllEmloyees all = new AllEmloyees();
        System.out.println();
        System.out.println("Всі робітники");
        all.showAll();
    }

    static class AllEmloyees {
        void showAll() throws FileNotFoundException {
            File doc = new File("Employees.txt");
            Scanner obj = new Scanner(doc);
            String info = "";
            while (obj.hasNextLine()) {
                info += obj.nextLine() + "\n";
            }
            System.out.println(info);
        }
    }

    @Override
    void showAppointmentsT() throws FileNotFoundException {
        File doc = new File("Appointments.txt");
        Scanner obj = new Scanner(doc);
        String info = "";
        while (obj.hasNextLine()) {
            info = obj.nextLine();
            if(info.contains("Історія") || info.contains("English")) {
                System.out.println(info);
            }
        }
    }

    @Override
    void showAppointmentsK() throws FileNotFoundException {
        File doc = new File("Appointments.txt");
        Scanner obj = new Scanner(doc);
        String info = "";
        while (obj.hasNextLine()) {
            info = obj.nextLine();
            if(info.contains("Кухар") || info.contains("Кондитер")) {
                System.out.println(info);
                System.out.println();
            }
        }
    }
}
