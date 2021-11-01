package com.lewiscode;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static char[][] h = new char[3][3];
    static int counter =0;
    public static void main(String[] args) {
	// write your code here
        display();
        boolean quite = false;
        while (!quite) {
            // Allowing user to input the coordinates
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
                //switching between player
                if (counter % 2 == 0) {
                    h[input1 - 1][input2 - 1] = 'X';
                }else {
                    h[input1-1][input2-1] = 'O';
                }
                counter++;
                //outputting players input
                System.out.println("---------");
                for (char[] chars : h) {
                    System.out.print("| ");
                    for (char aChar : chars) {
                        if (aChar == 0){
                            aChar = ' ';
                        }
                        System.out.print(aChar);
                        System.out.print(" ");
                    }
                    System.out.println("|");
                }
                System.out.println("---------");
                // showing the game  winner or if the game ended as a draw
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
                if (oWin) {
                    System.out.println("O wins");
                    quite = true;
                } else if(xWin) {
                        System.out.println("X wins");
                        quite = true;
                } else  if(noOfX + noOfO == 9 ){
                        System.out.println("Draw");
                        quite = true;
                }
            }

        }

    }
    // display an empty tic-tac-toe grid
    public static void display(){
        System.out.println("---------");
        for (char[] chars : h) {
            System.out.print("| ");
            for (char aChar : chars) {
                aChar = ' ';
                System.out.print(aChar);
                System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    //checking for a winner
    public static boolean wins(char win){
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
