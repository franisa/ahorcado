
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] words;
        String word, usedLetters;
        char[] mask;
        boolean win, find;
        int errors;
        char letter, cont;
        Scanner scanner = new Scanner(System.in);

        words = fillWords();
        do {
            word = chooseWord(words);
            mask = createMask(word);
            usedLetters = "";
            errors = 0;
            do {
                showMan(errors);
                showLetters("LETRAS UTILIZADAS", usedLetters);
                //System.out.println(String.valueOf(mask));
                showLetters("PALABRA", String.valueOf(mask));

                letter = Character.toUpperCase(askLetter());

                if (!usedLetters.contains(Character.toString(letter))) {
                    usedLetters += letter;
                    find = updateMask(word, mask, letter);
                    if (!find) {
                        errors++;
                    }
                } else {
                    System.out.println("Ya habías utilizado esa letra");
                    errors++;
                }

                win = word.equals(String.valueOf(mask));
            } while (!win && errors < 6);

            showLetters("PALABRA", word);
            if (!win) {
                showMan(errors);
            } else {
                showWin();
            }

            System.out.print("¿Qieres jugar otra vez (S/N): ");
            cont = Character.toUpperCase(scanner.next().charAt(0));

        } while (cont == 'S');
    }

    private static void showLetters(String titles, String word) {
        System.out.println(titles);
        for (int i = 0; i < word.length(); i++) {
            System.out.print(" _____ ");
        }

        System.out.println();
        for (int i = 0; i < word.length(); i++) {
            System.out.print("|     |");
        }

        System.out.println();
        for (int i = 0; i < word.length(); i++) {
            System.out.print("|  " + word.charAt(i) + "  |");
        }

        System.out.println();
        for (int i = 0; i < word.length(); i++) {
            System.out.print("|_____|");
        }

        System.out.println();
    }

    private static void showWin() {
        System.out.println(" .-=========-.");
        System.out.println(" \\'-=======-'/");
        System.out.println(" _|   .=.   |_");
        System.out.println("((|  {{1}}  |))");
        System.out.println(" \\|   /|\\   |/");
        System.out.println("  \\__ '`' __/");
        System.out.println("    _`) (`_");
        System.out.println("  _/_______\\_");
        System.out.println(" /___________\\");

    }

    private static boolean updateMask(String word, char[] mask, char letter) {
        boolean find = false;
        for (int j = 0; j < word.length(); j++) {
            if (word.charAt(j) == letter) {
                mask[j] = letter;
                find = true;
            }
        }

        return find;
    }

    private static char askLetter() {
        char letter;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Letra: ");
        letter = scanner.next().charAt(0);

        return letter;
    }

    private static void showMan(int errors) {

        System.out.println("   +---+");
        System.out.println("   |   |");

        switch (errors) {
            case 0:
                System.out.println("       |");
                System.out.println("       |");
                System.out.println("       |");
                break;
            case 1:
                System.out.println("   O   |");
                System.out.println("       |");
                System.out.println("       |");
                break;
            case 2:
                System.out.println("   O   |");
                System.out.println("   |   |");
                System.out.println("       |");
                break;
            case 3:
                System.out.println("   O   |");
                System.out.println("  /|   |");
                System.out.println("       |");
                break;
            case 4:
                System.out.println("   O   |");
                System.out.println("  /|\\  |");
                System.out.println("       |");
                break;
            case 5:
                System.out.println("   O   |");
                System.out.println("  /|\\  |");
                System.out.println("  /    |");
                break;
            case 6:
                System.out.println("   O   |");
                System.out.println("  /|\\  |");
                System.out.println("  / \\  |");
                break;
        }

        System.out.println("       |");
        System.out.println("=========");
    }

    private static char[] createMask(String word) {
        char[] mask = new char[word.length()];
        Arrays.fill(mask, '-');

        return mask;
    }

    private static String chooseWord(String[] words) {
        Random random = new Random();

        return words[random.nextInt(0, words.length)];
    }

    private static String[] fillWords() {
        String[] words = {
                "ELEFANTE", "COMPUTADORA", "UNIVERSIDAD", "ASTRONAUTA", "CAMION",
                "BICICLETA", "CIENCIA", "ASTRONOMIA", "LIBERTAD", "TIGRE",
                "MARIPOSA", "CORAZON", "PLATANO", "DIAMANTE", "ESCALERA",
                "CUCHARA", "ZAPATO", "REVOLUCION", "TELEFONO", "LAMPARA",
                "ESTRELLA", "MURCIELAGO", "PARAGUAS", "LEON", "TORNILLO",
                "VENTANA", "HELADO", "PINTURA", "CASCADA", "MONTAÑA"
        };

        return words;
    }
}



