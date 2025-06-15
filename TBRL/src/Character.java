public abstract class Character {

    private int HP;
    private int attack;
    private int defend;
    private int magicAttack;
    private int specialAttack;

    void warrior() {
        this.HP = 100;
        this.attack = 20;
        this.defend = 30;
        this.magicAttack=10;
        this.specialAttack=40;
    }

    void mage() {
        this.HP = 70;
        this.attack = 10;
        this.defend = 25;
        this.magicAttack=60;
        this.specialAttack=35;
    }

    void rogue() {
        this.HP = 85;
        this.attack = 15;
        this.defend = 25;
        this.magicAttack=40;
        this.specialAttack=40;
    }

    void goblin() {
        this.HP=50;
        this.attack=15;
        this.defend=10;
    }
}
