import java.util.Arrays;
import java.util.Random;

public class Mazo {

    private Carta[] mazo;
    private int barajas;

    public Mazo(int barajas) {
        this.barajas = barajas;
        mazo = new Carta[52 * this.barajas];
        int cardNum = 0;
        int paloNum = 0;

        for (int i = 0; i < (4 * this.barajas); i++) {
            if (paloNum == 4) {
                paloNum = 0;
            }
            for (int j = 1; j <= 13; j++) {
                mazo[cardNum] = new Carta(j, Carta.PALOS[paloNum]);
                cardNum++;
            }
            paloNum++;
        }

        //System.out.println(Arrays.toString(mazo));

    }

    public void barajar() {
        Random random = new Random();

        for (int i = 0; i < mazo.length * 6; i++) {
            int x = random.nextInt(0, mazo.length-1);
            int y = random.nextInt(0, mazo.length-1);
            //System.out.println("[SHUFF]: Mezclando pos:" + x + ", " + mazo[x] + " --> pos: " + y + ", " + mazo[y]);

            Carta cartaTmp = mazo[x];
            mazo[x] = mazo[y];
            mazo[y] = cartaTmp;
        }
    }

    public Carta extraerCarta() {
        Random random = new Random();

        int x;
        do {
            x = random.nextInt(0, mazo.length-1);
        } while (mazo[x] == null);

        Carta cartaTmp = mazo[x];
        mazo[x] = null;

        return cartaTmp;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < barajas; i++) {
            for (int j = i * 52; j < (52 * (i+1)); j++) {
                if (!(mazo[j] == null)) {
                    if (j % 52 == 51) {
                        stringBuilder.append(mazo[j]);
                    } else {
                        stringBuilder.append(mazo[j] + ", ");
                    }
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
