import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        try {
            String[] vect = input.nextLine().split(" ");
            int position = input.nextInt();
            System.out.println(vect[position - 1]);
        }
        catch (ArrayIndexOutOfBoundsException errorOfPositionInVect){
            System.out.println("Invalid position! ");
        }
        catch (InputMismatchException errorCharacterInNumberInt){
            System.out.println("Position need a number!");
            errorCharacterInNumberInt.printStackTrace();    // nome da excecao . printStackTrace() aciona o
                                                            // historico de chamadas para melhor corrigir o erro
        }
        finally {
            System.out.println("End of program");
        }

        input.close();
    }
}
