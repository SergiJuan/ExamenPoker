public class Carta {
    private int numero;
    private String palo;
    public static final String[] PALOS = {"♠", "♥", "♦", "♣"};

    public Carta(int numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public int getNumber() {
        return numero;
    }

    @Override
    public String toString() {
        String numString;
        if (numero == 11) {
            numString = "J";
        } else if (numero == 12) {
            numString = "Q";
        } else if (numero == 13) {
            numString = "K";
        } else {
            numString = String.valueOf(numero);
        }
        return numString + " de " + palo;
    }
}
