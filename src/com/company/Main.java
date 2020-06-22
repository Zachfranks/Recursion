package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static String[] keys = {"~","~-","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static void main(String[] args) {
	// write your code here

        Scanner numberReader = new Scanner(System.in);

        ArrayList<Integer> numberList = new ArrayList<Integer>();

        System.out.println(" enter numbers and add a space bettewn each one \n enter 'Done' when finished");

        while (numberReader.hasNextInt()) {
            int x = numberReader.nextInt();
            numberList.add(x);
        }

        String reslut = new String();
        ArrayList<String> output = listMnemonics(numberList,reslut);

        System.out.println(output);

    }
    static ArrayList<String> listMnemonics(ArrayList<Integer> numberList, String reslut){

        //System.out.println("list "+numberList);
        //System.out.println("result "+reslut);
        ArrayList<String> output;
        output = new ArrayList<>();

        if (numberList.size()==0){
         //termation case
            //System.out.println(reslut);
            output.add(reslut);

        }else {
            ArrayList<Integer> newNumberList = new ArrayList<>(numberList);
            int number = newNumberList.remove(0);
            for (int i =0; i < keys[number].length(); ++i ){
                String newReslut = reslut + keys[number].charAt(i);
                output.addAll( listMnemonics(newNumberList,newReslut));

            }
        }
        return output;
    }
}
