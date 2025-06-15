import java.util.Scanner;

public class Game {

    int playerRole;

    Scanner scanner = new Scanner(System.in);

    void welcome() {
        System.out.println();
        System.out.println(">=============================<");
        System.out.println(">===>>> Welcome tO TbRL <<<===<");
        System.out.println(">=============================<");
        System.out.println();
    }

    void chooseRole() {
        System.out.print("""
                Choose you role (1/2/3):
                1. Warrior (High HP, Medium Attack)
                2. Mage (Low HP, High Magic)
                3. Rogue (Fast, High Crit)
                
                >\s""");
        playerRole = scanner.nextInt();
        System.out.println();

        switch (playerRole) {
            case 1 -> System.out.println("You have chosen: Warrior!");
            case 2 -> System.out.println("You have chosen: Mage!");
            case 3 -> System.out.println("You have chosen: Rogue!");
            default -> System.out.println("W: Choose from only (1/2/3)");
        }
    }
}
