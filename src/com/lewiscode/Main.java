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
        System.out.println("---------");
        for (int i=0;i<3;i++){
            System.out.print("| ");
            for (int j =0;j<3;j++) {
                h[i][j] = str.charAt(count);
                count++;
                System.out.print(h[i][j]);
                System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
        int noOfX=0;
        int noOfO=0;
        for (char[] chars : h) {
            for (char aChar : chars) {
                if (String.valueOf(aChar).contains("X")) {
                    noOfX++;
                }
                if (String.valueOf(aChar).contains("O")) {
                    noOfO++;
                }
            }
        }
        boolean xWin = wins('X');
        boolean oWin = wins('O');
        if(xWin && oWin || noOfO - noOfX > 1 || noOfX - noOfO > 1){
            System.out.println("Impossible");
        }else if (oWin){
            System.out.println("O wins");
        } else if(xWin) {
            System.out.println("X wins");
        } else  if(noOfX + noOfO == 9 ){
            System.out.println("Draw");
        }else if(str.indexOf("_") > 0){
            System.out.println("Game not finished");
        }


    }
    public  static boolean wins(char win){
        return h[0][0] == win && h[0][1] == win && h[0][2] == win ||
                h[1][0] == win && h[1][1] == win && h[1][2] == win ||
                h[2][0] == win && h[2][1] == win && h[2][2] == win ||
                h[0][0] == win && h[1][0] == win && h[2][0] == win ||
                h[0][1] == win && h[1][1] == win && h[2][1] == win ||
                h[0][2] == win && h[1][2] == win && h[2][2] == win ||
                h[0][0] == win && h[1][1] == win && h[2][2] == win ||
                h[0][2] == win && h[1][1] == win && h[2][0] == win;
    }

}
