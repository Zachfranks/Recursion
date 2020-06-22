package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //list of what the nubers equal
    static String[] keys = {"~","~-","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static void main(String[] args) {
	// write your code here

        //scanner
        Scanner numberReader = new Scanner(System.in);

        //ArrayList to add the numbers to
        ArrayList<Integer> numberList = new ArrayList<Integer>();

        //instrctions for the user
        System.out.println(" enter numbers and add a space bettewn each one \n enter 'Done' when finished");

        //add what user tpyes into to the array
        while (numberReader.hasNextInt()) {
            int x = numberReader.nextInt();
            numberList.add(x);
        }

        //varuble
        String reslut = new String();

        //Arraylist
        ArrayList<String> output = listMnemonics(numberList,reslut);

        //display the output
        System.out.println(output);

    }
    static ArrayList<String> listMnemonics(ArrayList<Integer> numberList, String reslut){

        //debug stuff
        //System.out.println("list "+numberList);
        //System.out.println("result "+reslut);

        //more arrys
        ArrayList<String> output;
        output = new ArrayList<>();

        //if the list is not populated
        if (numberList.size()==0){
         //termation case
            //System.out.println(reslut);
            output.add(reslut);


        }
        //if the list is not populated
        else {
            ArrayList<Integer> newNumberList = new ArrayList<>(numberList);
            int number = newNumberList.remove(0);
            for (int i =0; i < keys[number].length(); ++i ){
                String newReslut = reslut + keys[number].charAt(i);
                output.addAll( listMnemonics(newNumberList,newReslut));

            }
        }

        //return the results
        return output;
    }
}
