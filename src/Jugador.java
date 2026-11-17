import java.util.Arrays;

public class Jugador {
    private String nombre;
    private Carta[] cartas = new Carta[20];

    public Jugador(String nombre) {
        this.nombre = nombre;

        for (int i = 0; i < 20; i++) {
            cartas[i] = null;
        }

        //System.out.println(Arrays.toString(cartas));
    }

    public void repartirCarta(Carta carta) {
        for (int i = 0; i < 20; i++) {
            if (cartas[i] == null) {
                cartas[i] = carta;
                break;
            }
        }
    }

    public int getPuntuacion() {
        int puntuacion = 0;
        for (int i = 0; i < cartas.length; i++) {
            if (!(cartas[i] == null)) {
                if (cartas[i].getNumber() == 1) {
                    if (puntuacion + 11 > 21) {
                        puntuacion += cartas[i].getNumber();
                    } else {
                        puntuacion += 11;
                    }
                } else {
                    puntuacion += cartas[i].getNumber();
                }

            }
        }
        return puntuacion;
    }

    @Override
    public String toString() {
        //System.out.println(Arrays.toString(cartas));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < cartas.length; i++) {
            if (!(cartas[i] == null)) {
                if (i % 20 == 0) {
                    stringBuilder.append(cartas[i]);
                } else {
                    stringBuilder.append(", " + cartas[i]);
                }

            }
        }
        return nombre + ": " + stringBuilder;
    }
}
