/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a2_task1;

import java.util.*;
/**
 * For obtaining 3 letter word from a 5 letter word that is entered
 * @author VinayaSaiD
 */
public class A2_Task1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("P[rogram start");
        stringManipulation application = new stringManipulation();
        String enteredString = application.getString();
        application.printString(enteredString);
    }
/**
 * Ask the user to enter the string of length 5, if it is not of length 5 ask him to enter again, 
 * Then print all the strings of length 3 from the give 5 letter word, 
 * getString() is to take the input from user - string of length 5, 
 * printString() is to print the output strings of length 3.
 */    
public static class stringManipulation {
       // To get the input from the user and check the length of string 
       // Request to enter again if string is not of length 5
       public static String getString(){
           Scanner input = new Scanner(System.in);
           String entered;
           int length = 0;
           do{
               System.out.print("Enter a string of length 5: ");
               entered = input.nextLine();
               // Removing empty spaces if any
               entered = entered.replaceAll("\\s","");
               length = entered.length();
               // Checking if entered string is of length 5 or not and asking to enter again
               if (length != 5) {
                   System.out.println("String entered is not of length 5");
               }
           }
           while (length!=5);
           return entered;
          }  
       public static void printString(String entered){   
           int length = entered.length();
           char[] alphabets = new char[5];
           // changing string to character Array
           for (int i=0;i<5;i++){
               alphabets[ i ] = entered.charAt( i );
           }
           //System.out.println(Arrays.toString(alphabets));
           int a = 1; //counter to add the number of 3 letter words formed
           Set<String> st = new HashSet<String>(); //set to remove the duplicates
           for (int i =0; i<length; i++)
           {
               for (int j=0;j<length;j++){
                   // checking if first and second positions are same
                   if (i==j){
                       continue;
                   }
                   for (int k=0;k<length;k++){
                       // checking if third is same as first or second
                       if (i==k || j==k){
                           continue;
                       }
                       System.out.format("(%2d) %s%s%s\n",a,alphabets[i],alphabets[j],alphabets[k]);
                       // creating temp variable of 3 letter string
                       String temp = ""+(alphabets[i]) + alphabets[j]+alphabets[k];
                       //adding temp to set to remove the duplicates
                       st.add(temp);
                       a++;
                   }
               }
           }
           //Print the values without repetition
           System.out.println("Size of the set without repetition: "+ st.size());
           System.out.println("set of 3 letter words: " + st);
       } 
    }
}        

