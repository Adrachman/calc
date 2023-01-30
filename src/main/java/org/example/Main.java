package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ВВЕДИТЕ ДАННЫЕ ЧЕРЕЗ ОДИН ПРОБЕЛ"); // 5 + 6 или X +IX
        String input = scanner.nextLine();
        System.out.println(Main.calc(input));

    }

    public static String calc(String input) throws Exception {

        String str[] = input.split(" ");
        String strRim[] = input.split(" ");
        String rimNumber[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        for (int a = 0; a < rimNumber.length; a++) {
            if (str[0].equals(rimNumber[a])) {
                for (int l = 0; l <= rimNumber.length; l++) {
                    if (str[2].equals(String.valueOf(l + 1))) {
                        throw new Exception("Несовместимые системы счисления!");
                    }
                }
            }
        }
        for (int a = 0; a < rimNumber.length; a++) {
            if (str[2].equals(rimNumber[a])) {
                for (int l = 0; l <= rimNumber.length; l++) {
                    if (str[0].equals(String.valueOf(l + 1))) {
                        throw new Exception("Несовместимые системы счисления!");
                    }
                }
            }
        }

        String tempVal = str[0];
        for (int i = 0; i < rimNumber.length; i++) {
            if (str[0].equals(rimNumber[i])) {
                str[0] = String.valueOf(i + 1);
            }
            if (str[2].equals(rimNumber[i])) {
                str[2] = String.valueOf(i + 1);
            }
        }

        int temp1 = Integer.parseInt(str[0]);
        int temp2 = Integer.parseInt(str[2]);
        int res = 0;

        if (str[1].equals("+")) {
            res = temp1 + temp2;
        } else if (str[1].equals("-")) {
            res = temp1 - temp2;
        } else if (str[1].equals("/")) {
            res = temp1 / temp2;
        } else if (str[1].equals("*")) {
            res = temp1 * temp2;
        } else {
            System.out.println("Ошибка");
        }

        String aut = String.valueOf(res);
        String last = aut;
        String tem[];

        for (int i = 0; i < rimNumber.length; i++){
            if (tempVal.equals(rimNumber[i])) {
                tem = aut.split("");
                if (tem.length > 1) {
                    int a = Integer.parseInt(tem[0]);
                    int b = Integer.parseInt(tem[1]);
                    if (a < 4){
                        last = rimNumber[a-1];
                        last += rimNumber[b-1];
                    }else if (a >= 4){
                        last = "XL";
                        try {
                            last += rimNumber[b-1];
                            return last;
                        } catch (ArrayIndexOutOfBoundsException e){
                            return last;
                        }
                    }else if(a == 5){
                        last = "L";

                    } else if (a > 5){
                        last = "LX";
                        try {
                            last += rimNumber[b-1];
                            return last;
                        } catch (ArrayIndexOutOfBoundsException e){
                            last += rimNumber[9];
                            return last;
                        }
                    } else if (a > 6){
                        last = "LXX";
                        try {
                            last += rimNumber[b-1];
                            return last;
                        } catch (ArrayIndexOutOfBoundsException e){
                            last += rimNumber[9];
                            return last;
                        }
                    } else if (a > 7){
                        last = "LXXX";
                        try {
                            last += rimNumber[b-1];
                            return last;
                        } catch (ArrayIndexOutOfBoundsException e){
                            last += rimNumber[9];
                            return last;
                        }
                    } else if (a > 8){
                        last = "LC";
                        try {
                            last += rimNumber[b-1];
                            return last;
                        } catch (ArrayIndexOutOfBoundsException e){
                            last += rimNumber[9];
                            return last;
                        }
                    }

                } else {
                    int temp = Integer.parseInt(tem[0])-1;
                    last = rimNumber[temp];
                    if (temp < 0){
                        throw new Exception("Значение не может быть меньше 0");
                    }
                    return last;
                }
            }
        }

        return aut;

    }
}