import java.util.Scanner;

import java.util.Scanner;
public class Numeros {

        public static void main(String[] args) {
            System.out.println("Hola Mundo");
            int i=0;
            int num1=0;
            int num2=0;
            int num3=0;
            System.out.println("Por favor ingrese 3 numeros");

            Scanner num = new Scanner(System.in);

            num1=num.nextInt();
            num2=num.nextInt();
            num3=num.nextInt();

            if ((num1>num2 && num2>num3)) {
                System.out.println("Los numeros son:"+num1 + " " + num2 + " " + num3);

            }else  if ((num2>num1 && num1>num3)) {
                System.out.println("Los numeros son:"+num2 + " " + num1 + " " + num3);
            } else if ((num3>num1 && num1>num2)) {
                System.out.println("Los numeros son:"+num3 + " " + num1 + " " + num2);
            } else if ((num1>num2 && num2<num3)) {
                System.out.println("Los numeros son:"+num1 + " " + num3 + " " + num2);
            } else if ((num2>num1 && num1<num3)) {
                System.out.println("Los numeros son:" + num2 + " " + num3 + " " + num1);
            } else if ((num2>num3 && num1>num3)) {
                System.out.println("Los numeros son:" + num2 + " " + num1 + " " + num3);

            }
        }
    }

