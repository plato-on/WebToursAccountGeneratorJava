package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static int amountOfUsers;
    private static final String randomUser = "username%s,password%s,firstname%s,lastname%s,addr1_%s,addr2_%s,pass1_%s,creditcardnum%s,expdatecard%s";

    public static void main(String[] args) throws IOException {
        getAmountOfUsers();
        outWriteAccountsDat(generateUsersArray(amountOfUsers));
        outWriteScriptUsers(amountOfUsers);
    }

    private static ArrayList<String> generateUsersArray(int amountOfUsers) {
        ArrayList<String> generatedUsersArray = new ArrayList<>();
        int countOfUsers =  0;
        while(amountOfUsers != 0) {
            countOfUsers++;
            String randomUser = String.format(Main.randomUser,countOfUsers,countOfUsers,countOfUsers,countOfUsers,countOfUsers,countOfUsers,countOfUsers,countOfUsers,countOfUsers);
            generatedUsersArray.add(randomUser);
            amountOfUsers--;
        }
        return generatedUsersArray;
    }

    private static void getAmountOfUsers() {
        System.out.println("Please, enter amount of users, you want to generate");
        Scanner scanner = new Scanner(System.in);
        amountOfUsers = scanner.nextInt();
    }

    private static void outWriteAccountsDat(ArrayList<String> arrayList) throws IOException {
        FileWriter writer = new FileWriter("Accounts.dat");
        writer.write( "USERNAME,PASSWORD,FIRSTNAME,LASTNAME,ADDR1,ADDR2,PASS1,CREDITCARDNUM,EXPDATECARD" + "\n");
        for(Object str: arrayList) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }

    private static void outWriteScriptUsers(int amountOfUsers) throws IOException {
        String userName = "username%s";
        String password = "password%s";
        String firstName = "firstname%s";
        String lastName = "lastname%s";
        String addr1 = "addr1_%s";
        String addr2 = "addr2_%s";

        int count = 0;
        while(amountOfUsers != 0) {
            //String path = "C:" + File.separator + "WebTours" + File.separator + "cgi-bin" + File.separator + "users" + File.separator + String.format(userName, count); //для генерации по адресу С:\Webtours\cgi-bin\users
            //File file = new File(path);
            //FileWriter writer = new FileWriter(file);
            FileWriter writer = new FileWriter(String.format(userName, count)+".dat"); //раскомментируй, если нужно насоздавать пользователей там же, где и файл Accounts, а 3 строчки выше - закомментируй
            writer.write(String.format(password, count) + "\n" + String.format(firstName, count) + ";" + String.format(lastName, count)
                    + "\n" + String.format(addr1, count) + "\n" + String.format(addr2, count) + "\n" + ";");
            writer.close();
            count++;
            amountOfUsers--;
        }
    }

}
