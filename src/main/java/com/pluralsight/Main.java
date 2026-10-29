package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try{
            // create file writer and buffered writer objects
            FileWriter fileWriter = new FileWriter("logs.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(getDateTime() + " launch\n");
            String userInput;
            while (true) {

                System.out.printf("Enter a search term (X or x to exit): ");
                userInput = input.nextLine();

                if (userInput.equalsIgnoreCase("x")){
                    bufferedWriter.write(getDateTime() + " exit\n");

                    // close buffered writer
                    bufferedWriter.close();
                    return;
                } else {
                    bufferedWriter.write(getDateTime() + " search : " + userInput + "\n");
                }

            }

        } catch (IOException e){
            System.out.println("Issues opening File");
        }
    }

    public static String getDateTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return localDateTime.format(dateTimeFormatter);
    }


}