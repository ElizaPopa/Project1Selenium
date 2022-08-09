import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JavaErrors {
// throw - se foloseste atunci cand dorim sa arunca explicit o eroare
// throws - atentionare ca o metoda sau un constructor arunca o eroare/ exceptie
// try - catch - finally - cod unde ne putem defini un Handler pentru o exceptie/eroare de-a noastra

    public static void main(String[] args) throws IOException {
       try {
           throw new IOException( "Am trimis mesajul custom");
       } catch (MyCustomException e) {
           System.out.println("Am intrat pe ramura catch");
       }
        System.out.println("Main finished");

    }
    public static void ThrowsException() {
        throw new ArithmeticException();
    }
// checked exceptions /Users/mr.lee/Desktop/textEliza.txt
        public static void checkedExceptions () throws IOException {
            FileReader file = new FileReader("/Users/mr.lee/Desktop/textEliza.txt");
            BufferedReader fileInput = new BufferedReader(file);
            System.out.println(fileInput.readLine());
            fileInput.close();
        }

// unchecked exceptions
        public static void uncheckedExceptions () {

// NullPointerException
//        String cuvant = null;
//        cuvant.length();
// ArithmeticException
            int a = 10;
            int b = 0;
            int rezultat = a / b;
            System.out.println("Rezultatul este: " + rezultat);
        }
// StackOverflowError
        public static void metodaRecursiva ( int numar, int i){
            if (numar == 0) {
                System.out.println("Numarul este: " + numar);
                return;
            } else {
                System.out.println("Numarul este: " + i);
                i++;
                metodaRecursiva(numar,i);
            }
        }
        public static void metodaTryAndCatch () {
            try {
                String cuvant = "primavara";
                String rezultat = cuvant.toUpperCase();
                System.out.println("Rezultatul este: " + rezultat);

                int a = 10;
                int b = 5;
                int rezultat1 = a / b;
                System.out.println("Dupa exceptia aritmetica");

//        } catch (NullPointerException e) {
//            System.out.println("Catch block");
//            System.out.println(e.getCause());
//            System.out.println(e.getMessage());
//            e.printStackTrace();
            } finally {
                System.out.println("Finally block");
            }

//        try {
//            checkedExceptions();
//        } catch (IOException e) {
//            System.out.println("On catch block");
//        }
            System.out.println("Main finished");
        }
    }



