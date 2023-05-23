
public class Player extends Character{

    public static int numAtkUpgrades;
    public static int numDefUpgrades;

    int gold,restLeft,pots;

    //Habilidades
    public static String [] atkUpgrades = {"Força","Poder","Poderoso","Força Divina"};
    public static String [] defUpgrades = {"Ossos Pesados","Pele de Pedra","Pele de Escama","Aura Divina"};

    //Construtor do jogador
    public Player(String name) {
        super(name, 100, 0);
        this.numAtkUpgrades =0;
        this.numDefUpgrades =0;
        this.gold = 5;
        this.restLeft = 1;
        chooseTrait();
    }

    @Override
    public int ataque() {
        return (int)(Math.random()*(xp/4+numAtkUpgrades*3+3)+xp/10+numAtkUpgrades*2+numDefUpgrades+1);
    }

    @Override
    public int defende() {
        return (int)(Math.random()*(xp/4+numDefUpgrades*3+3)+xp/10+numDefUpgrades*2+numAtkUpgrades+1);
    }
    //jogador escolhe caracteristica
    public static void chooseTrait() {
        GameLogic.clearConsole();
        GameLogic.printHeading("Escolha o Atributo");
        System.out.println("(1) "+atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) "+defUpgrades[numDefUpgrades]);
        //pega a informaão do jogador
        int input = GameLogic.readInt("-> ",2);
        GameLogic.clearConsole();
        //escolhe das opções
        if(input == 1){
            GameLogic.printHeading("Voce escolheu "+atkUpgrades[numAtkUpgrades]+"!");
            numAtkUpgrades++;
        }else{
            GameLogic.printHeading(("Voce escolheu "+defUpgrades[numDefUpgrades])+"!");
            numDefUpgrades++;
        }
        GameLogic.anythingToContinue();
    }


}
