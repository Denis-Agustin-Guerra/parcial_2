import java.util.Scanner;

public class DNADetector {
    public static boolean isMutant(String[] dna) {
        int rows = dna.length;
        int cols = dna[0].length();

        int count = 0;

        // horizontal
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - 3; j++) {
                if (dna[i].charAt(j) == dna[i].charAt(j + 1) &&
                        dna[i].charAt(j) == dna[i].charAt(j + 2) &&
                        dna[i].charAt(j) == dna[i].charAt(j + 3)) {
                    count++;
                }
            }
        }

        // vertical
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows - 3; i++) {
                if (dna[i].charAt(j) == dna[i + 1].charAt(j) &&
                        dna[i].charAt(j) == dna[i + 2].charAt(j) &&
                        dna[i].charAt(j) == dna[i + 3].charAt(j)) {
                    count++;
                }
            }
        }

        // diagonal derecha abajo
        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < cols - 3; j++) {
                if (dna[i].charAt(j) == dna[i + 1].charAt(j + 1) &&
                        dna[i].charAt(j) == dna[i + 2].charAt(j + 2) &&
                        dna[i].charAt(j) == dna[i + 3].charAt(j + 3)) {
                    count++;
                }
            }
        }

        // diagonal izquierda abajo
        for (int i = 0; i < rows - 3; i++) {
            for (int j = 3; j < cols; j++) {
                if (dna[i].charAt(j) == dna[i + 1].charAt(j - 1) &&
                        dna[i].charAt(j) == dna[i + 2].charAt(j - 2) &&
                        dna[i].charAt(j) == dna[i + 3].charAt(j - 3)) {
                    count++;
                }
            }
        }

        return count > 1;
    }





    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa las filas de la matriz de ADN separadas por comas y entre comillas ej (\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"):");
        String input = scanner.nextLine();

        // saca las comillas y divide el input en filas individuales
        String[] dna = input.replace("\"", "").split(",");

        if (validateDNASequence(dna)) {
            boolean result = DNADetector.isMutant(dna);

            if (result) {
                System.out.println("Es un mutante.");
            } else {
                System.out.println("No es un mutante.");
            }
        } else {
            System.out.println("El formato es inválido. Cada secuencia de ADN debe tener exactamente 6 letras.");
        }
    }

    private static boolean validateDNASequence(String[] dna) {
        for (String sequence : dna) {
            if (sequence.length() != 6) {
                return false;
            }
        }
        return true;
    }

}
