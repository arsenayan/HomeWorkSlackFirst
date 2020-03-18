package com.company;

import java.io.*;
import java.util.Scanner;

import static java.io.File.createTempFile;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean state = true;


        File file = new File("wordFile.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();

            }
            boolean exists = file.exists();

            System.out.println("First file exists : " + exists);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (state) {
            String str = scanner.nextLine();
            if (str.equalsIgnoreCase("exit")) {


                state = false;
            } else {
                try {
                    String[] s = str.split(",");
                    writeToFile(file, str);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }


    }

    public static void writeToFile(File file, String data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write(data);
        writer.write(System.lineSeparator());
        writer.flush();
        writer.close();


    }

    public static void modify(File fileToRead) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileToRead));


        String str;
        int wordCount = 0;

        while ((str = reader.readLine()) != null) {


            if (str.equalsIgnoreCase("hello")) {
                wordCount++;
            }

        }


        reader.close();


        System.out.println(str);
    }
    /*public Integer count(int c) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("wordFile.txt"));

        String str;
        int wordCount = 0;

        while ((str = reader.readLine()) != null) {

            str = str.toUpperCase();
            if (str.equalsIgnoreCase("hello")) {
                wordCount++;
            }

        }
        c=wordCount;

        reader.close();

        return c;
    }*/
}
