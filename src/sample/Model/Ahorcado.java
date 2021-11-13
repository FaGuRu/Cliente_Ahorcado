package sample.Model;

public class Ahorcado {
    private String palabraOculta;
    private short numeroStrike = 0;
    private char[] copiaPalabraOculta;
    private final short MAX_VIDAS = 5;

    public Ahorcado(String palabraOculta) {
        this.palabraOculta = palabraOculta;
    }

    public void generarPalabra() {
        copiaPalabraOculta = new char[palabraOculta.length()];
        for (int i = 0; i < copiaPalabraOculta.length; i++) {
            copiaPalabraOculta[i] = '-';
        }
    }

    public String getPalabraOculta() {
        return palabraOculta;

    }

    public void verificarPalabra(char letra) {
        boolean letraEncontrada = false;
        for (int i = 0; i < palabraOculta.length(); i++) {
            if (palabraOculta.charAt(i) == letra) {
                letraEncontrada = true;
                copiaPalabraOculta[i] = letra;
            }
        }
        if (!letraEncontrada) numeroStrike++;

    }

    public char[] imprimirProgreso() {
        System.out.print(copiaPalabraOculta);
        return copiaPalabraOculta;

    }

    public boolean isPlayAgain() {
        return (numeroStrike == MAX_VIDAS) ? false : true;
    }

    public boolean isWordFound() {
        return String.valueOf(copiaPalabraOculta).equals(palabraOculta) ? true : false;
    }

    public short getNumStrike() {
        return numeroStrike;
    }
}