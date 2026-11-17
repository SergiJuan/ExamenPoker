import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Mazo mazo = new Mazo(2);
        mazo.barajar();

        //System.out.println(mazo);


        Jugador jugador = new Jugador("Sergi");
        jugador.repartirCarta(mazo.extraerCarta());
        jugador.repartirCarta(mazo.extraerCarta());


        System.out.println(jugador);
        System.out.println(jugador.getPuntuacion());

        while (choiceOption(jugador)) {

            jugador.repartirCarta(mazo.extraerCarta());
            System.out.println(jugador);
            System.out.println(jugador.getPuntuacion());
        }
    }

    public static boolean choiceOption(Jugador jugador) {
        Scanner scanner = new Scanner(System.in);

        if (!(jugador.getPuntuacion() <= 21)) {
            System.out.println("Has perdido !!!");
            return false;
        }

        if (jugador.getPuntuacion() == 21) {
            System.out.println("VICTORIA 21!");
            return false;
        }

        String opcion;
        System.out.print("Quieres pedir otra carta? ");
        opcion = scanner.next();

        switch (opcion) {
            case "si":
                return true;
            case "no":
                System.out.println("Te has plantado!");
                return false;
            default:
                System.out.println("Error: solo puedes poner si o no.");
                choiceOption(jugador);
                break;
        }
    return false;
    }
}