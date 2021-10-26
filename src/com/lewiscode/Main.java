package com.lewiscode;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static char[][] h = new char[3][3];
    public static void main(String[] args) {
	// write your code here
        System.out.println("Enter cells: ");
        String str = scanner.nextLine();
        int count =0;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                h[i][j] = str.charAt(count);
                count++;
            }
        }
        System.out.println("---------");
        for (int i=0;i<3;i++){
            System.out.print("| ");
            for (int j =0;j<3;j++) {
                System.out.print(h[i][j]);
                System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
        int noOfX=0;
        int noOfO=0;
        for (int i=0;i<str.length()-1;i++){
            if (str.charAt(i) =='X'){
                noOfX++;
            }else if(str.charAt(i) == 'O'){
                noOfO++;
            }
        }
        boolean x =wins('X');
        boolean o =wins('O');
        if (str.indexOf(' ') > 0){
            System.out.println("Game not finished");
        }else if(draw(str,x,o)){
            System.out.println("Draw");
        }else if(x){
            System.out.println("X wins");
        }else if (o){
            System.out.println("O wins");
        }else if(noOfX < noOfO-1 || noOfO < noOfX-1 || noOfO > noOfX+1 || noOfX > noOfO+1
                || x&&o){
            System.out.println("Impossible");
        }

    }
    public static boolean wins(char x){
        int count ;
        for (char[] chars : h) {
            count = 1;
            for (char aChar : chars) {
                if (aChar != x) {
                    break;
                }
                count++;
                if (count == 3) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean draw( String str,boolean x,boolean o){
        if (!x && !o && str.length() ==9){
            return true;
        }else {
            return false;
        }
    }
}
