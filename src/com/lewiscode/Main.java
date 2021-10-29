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
//        int noOfX=0;
//        int noOfO=0;
//        for (char[] chars : h) {
//            for (char aChar : chars) {
//                if (String.valueOf(aChar).contains("X")) {
//                    noOfX++;
//                }
//                if (String.valueOf(aChar).contains("O")) {
//                    noOfO++;
//                }
//            }
//        }
//        boolean xWin = wins('X');
//        boolean oWin = wins('O');
//        if(xWin && oWin || noOfO - noOfX > 1 || noOfX - noOfO > 1){
//            System.out.println("Impossible");
//        }else if (oWin){
//            System.out.println("O wins");
//        } else if(xWin) {
//            System.out.println("X wins");
//        } else  if(noOfX + noOfO == 9 ){
//            System.out.println("Draw");
//        }else if(str.indexOf("_") > 0){
//            System.out.println("Game not finished");
//        }

        // user should input two coordinates
        boolean quite = false;
        while (!quite) {
            System.out.println("Enter the coordinates:");
            String coordinates = scanner.nextLine();
            String s = coordinates.substring(0,1);
            String d = coordinates.substring(2);
            int input1;
            int input2;
            try {
                input1 = Integer.parseInt(s);
                input2 = Integer.parseInt(d);
            } catch (NumberFormatException e){
                System.out.println("You should enter numbers!");
                continue;
            }

            if (input1 < 1 || input1 > 3 || input2 < 1 || input2 > 3 ){
                System.out.println("Coordinates should be from 1 to 3!");
            }else if (h[input1-1][input2-1] == 'X' || h[input1-1][input2-1] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
            }else {
                h[input1-1][input2-1] = 'X';
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
                quite = true;
            }

        }

    }

//    public static boolean wins(char win){
//        return h[0][0] == win && h[0][1] == win && h[0][2] == win ||
//                h[1][0] == win && h[1][1] == win && h[1][2] == win ||
//                h[2][0] == win && h[2][1] == win && h[2][2] == win ||
//                h[0][0] == win && h[1][0] == win && h[2][0] == win ||
//                h[0][1] == win && h[1][1] == win && h[2][1] == win ||
//                h[0][2] == win && h[1][2] == win && h[2][2] == win ||
//                h[0][0] == win && h[1][1] == win && h[2][2] == win ||
//                h[0][2] == win && h[1][1] == win && h[2][0] == win;
//    }
}
