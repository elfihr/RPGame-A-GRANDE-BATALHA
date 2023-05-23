import java.sql.SQLOutput;
import java.util.Scanner;

public class GameLogic {
    static Scanner leia = new Scanner(System.in);
    static Scanner leiaString = new Scanner(System.in);

    static Player player;

    public static boolean isRunning;

    //Encontro Aleatorio
    public static String[] encounters = {"Batalha","Batalha","Batalha","Descanso","Descanso"};

    //enemy names
    public static String [] enemies = {"Ogre","Ogre","Goblin","Goblin","Stone Elemntal"};

    //elementos da historia
    public static int place = 0,act =1;
    public static String[] places = {"Montanhas sem Fim","Planicies Desoladas","Castelo do Imperador Malvado","Sala do Trono"};

    //Metodo para get saida no console
    public static int readInt(String prompt, int userChoices)
    {
        int input;

        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(leia.next());
            }catch(Exception e) {
                input = -1;
                System.out.println("Por favor ultiliza um numero inteiro!");
            }
        }while(input < 1 || input > userChoices);
        return input;
    }

    //metodo simular limpeza do console
    public static void clearConsole() {
        for(int i = 0;i<100;i++)
            System.out.println();
    }

    //metodo de print com separador de espaço
    public static void printSeparator(int n) {
        for(int i = 0;i<n;i++)
            System.out.print("-");
        System.out.println();
    }

    //metodo de print cabeçalho
    public static void printHeading(String title) {
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    //metodo para parar o jogo ate usuario digitar algo
    public static void anythingToContinue() {
        System.out.println("\nPressione quelaque tecla para CONTINUAR");
        leiaString.nextLine();
    }

    public static void startGame(){
        Boolean nameSet = false;
        String name;
        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("The Darkwood");
        System.out.println("A elFihr production");
        printSeparator(30);
        printSeparator(40);
        anythingToContinue();
        do{
            clearConsole();
            printHeading("Qual seu nome");
            name = leia.next();
            clearConsole();
            printHeading("Seu nome é "+name+"\nÉ isso mesmo");
            System.out.println("(1) - SIM\n(2) - NÃO ");
            int input = readInt("-> ",2);
            if(input ==1)
                nameSet = true;
        }while(!nameSet);

        //Inicio da Historia
        Historia.printIntro();

        //criação de objeto Player para o nome
        player = new Player(name);

        //Capitulo 1 da Historia
        Historia.printFirstActIntro();

        //set o jogo como true para continuar
        isRunning=true;

        //inicia loop main game
        gameLoop();
    }

    //metodo varia de acordo com xp
    public static void checkAct(){
        if(player.xp >= 10 && act ==1){
            //Aumenta o ato e local
            act =2;
            place =1;
            //Historia
            Historia.printFirstActOutro();
            //Level UP
            Player.chooseTrait();
            //Historia
            Historia.printSecondActIntro();
            //Atribui valores aos inimigos
            enemies[0] = "Mercenario Malvado";
            enemies[1] = "Goblin";
            enemies[2] = "Lobo";
            enemies[3] = "Lanceiro do Malvado Imperador";
            enemies[4] = "Estranho Assustador";
            //Atribui valores ao encontro
            encounters[0] = "Batalha";
            encounters[1] = "Batalha";
            encounters[2] = "Batalha";
            encounters[3] = "Descanso";
            encounters[4] = "Loja";
        }else if(player.xp >= 50 && act == 2){
            act =3;
            place = 2;
            Historia.priprintSecondActOutro();
            Player.chooseTrait();
            Historia.printThirdActIntro();
            //Atribui valores aos inimigos
            enemies[0] = "Mercenario Malvado";
            enemies[1] = "Mercenario Malvado";
            enemies[2] = "Lanceiro do Malvado Imperador";
            enemies[3] = "Lanceiro do Malvado Imperador";
            enemies[4] = "Lanceiro do Malvado Imperador";
            //Atribui valores ao encontro
            encounters[0] = "Batalha";
            encounters[1] = "Batalha";
            encounters[2] = "Batalha";
            encounters[3] = "Batalha";
            encounters[4] = "Loja";
            //recuperação hp Jogador
            player.hp = player.maxHp;
        }else if(player.xp >= 100 && act == 3){
            act =4;
            place = 3;
            Historia.printThirdActOutro();
            Player.chooseTrait();
            Historia.printFourthActIntro();
            //recuperação hp Jogador
            player.hp = player.maxHp;
            //Boss Final
            finalBattle();
        }
    }
    //Metodo para Calcular Encontro Aleatorio
    public static void randomEnconter(){
        int encounter = (int) (Math.random() * encounters.length);
        //Chamar o metodo
        if(encounters[encounter].equals("Batalha")) {
            randomBattle();
        }else if(encounters[encounter].equals("Descanso")){
            takeRest();
        }else{
            shop();
        }
    }

    //metodo continuar aventura;
    public static void continueJourney(){
        checkAct();{
            if(act != 4)
                randomEnconter();
        }
    }

    //info do personagem
    public static void characterInfo(){
        clearConsole();
        printHeading("Informação do Personagem");
        System.out.println(player.name+"\tHP: "+player.hp+"/"+player.maxHp);
        printSeparator(20);
        System.out.println("XP: "+player.xp + "\tOuro: "+player.gold);
        printSeparator(20);
        //numero de poções
        System.out.println("# de poções " +player.pots);

        //caracteristicas
        if(player.numAtkUpgrades >0){
            System.out.println("Atributo de Ataque: "+player.atkUpgrades[player.numAtkUpgrades -1]);
            printSeparator(20);
        }
        if(player.numDefUpgrades > 0){
            System.out.println("Atributo de Defesa: "+player.defUpgrades[player.numDefUpgrades -1]);
        }
        anythingToContinue();
    }

    public static void shop(){
        clearConsole();
        printHeading("Um misterioso mercador apareceu!!\nEle lhe ofere alguns de seus itens");
        int price = (int)(Math.random()*(10+player.pots*3)+ 10 +player.pots);
        System.out.println("-POÇÂO "+price+" ouro.");
        printSeparator(20);
        System.out.println("Gostaria de comprar uma poção?\n(1)SIM\n(2)NÂO");
        int input = readInt("->",2);
        //chegando se jogador quer comprar
        if(input == 1){
            clearConsole();
            //checar se jogador tem dinheiro
            if(player.gold >= price){
                printHeading("Voce comprou a poção pelo preço de "+price+" ouro.");
                player.pots++;
                player.gold -= price;
            }else {
                printHeading("Você nao tem ouro o bastante para comprar a poção...");
                anythingToContinue();
            }
        }
    }

    //Metodo para jogador descansar
    public static void takeRest(){
        clearConsole();
        if(player.restLeft >= 1) {
            printHeading("Você quer descansar?("+player.restLeft+" descanso(s) restante).");
            System.out.println("(1)SIM\n(2)NÂO.");
            int input = readInt("->",2);
            //jogador decide descansar
            clearConsole();
            if (player.hp < player.maxHp){
                int hpRestored = (int) (Math.random() * (player.xp/4+  1) + 10);
                player.hp += hpRestored;
                if(player.hp > player.maxHp)
                    player.hp = player.maxHp;
                System.out.println("Você descansou e recuperou "+hpRestored+" Vida");
                System.out.println("Vida do jogador agora é "+player.hp+"/"+player.maxHp+" Vida");
                player.restLeft --;
            }
        }else {
            System.out.println("Sua vida ja esta cheia. Voce não pode descansar agora!");
            anythingToContinue();
        }
    }

    //Criação de encontro aleatorio
    public static void randomBattle(){
        clearConsole();
        printHeading("Voce encontrou um perigoso oponente em seu caminho! Prepare-se para a batalha!");
        anythingToContinue();
        //Criando inimigos com nome aleatorio
        battle(new Enemy(enemies[(int)(Math.random()*enemies.length)],player.xp));
    }

    //Metodo para batalha
    public static void battle(Enemy enemy){
        //looping de batalha
        while (true){
            clearConsole();
            printHeading(enemy.name+"\nHP: " +enemy.hp + "/" + enemy.maxHp);
            printHeading(player.name+"\nHP: " + player.hp +"/" + player.maxHp);
            System.out.println("Selecione a ação");
            printSeparator(20);
            System.out.println("(1)Lutar\n(2)Usar Poção\n(3)Fugir");
            int input =readInt("->",3);
            //reage de acordo com escolha do jogador
            if(input == 1){
                //Calcular dano e dano recebido - Luta
                int dmg= player.ataque() - enemy.defende();
                int dmgTook = enemy.ataque() - player.defende();
                //checar se dano nao é negativo
                if(dmgTook < 0) {
                    dmg -= dmgTook / 2;
                    dmgTook = 0;
                }
                if(dmg < 0)
                    dmg = 0;
                    //dano em ambos
                    player.hp -= dmgTook;
                    enemy.hp -= dmg;
                    //Informação dobre o dano
                    clearConsole();
                    printHeading("BATALHA");
                    System.out.println("Voce deu "+dmg+" de dano à "+enemy.name+".");
                    printSeparator(15);
                    System.out.println("O "+enemy.name+ " deu " +dmgTook + " dano em você.");
                    anythingToContinue();
                    if(player.hp <= 0){
                        playerDied(); //metodo para finalizar game
                            break;
                    } else if (enemy.hp <= 0) {
                        //Jogador Ganhou
                        clearConsole();
                        printHeading("Você derrotou o "+enemy.name);
                        //ganho de xp do jogador
                        player.xp += enemy.xp;
                        System.out.println("Voce ganhou "+enemy.xp+ " XP");
                        anythingToContinue();
                        //Drops do monstro
                        boolean addRest = (Math.random()*5+2<=2.25);
                        int goldEarned = (int)(Math.random()*enemy.xp);
                        if(addRest){
                            player.restLeft++;
                            System.out.println("Voce ganhou chance adicional para descansar");
                        }
                        if(goldEarned > 0){
                            player.gold += goldEarned;
                            System.out.println("Você ganhou "+goldEarned+" de ouro.");
                        }
                        break;
                }
            }else if(input == 2) {
                //Jogador usa poção
                clearConsole();
                if(player.pots > 0 && player.hp < player.maxHp){
                    //Jogador pode Usar a poção
                    System.out.println("Você quer beber uma poção? (" +player.pots+" restantes).");
                    System.out.println("(1) SIM\n(2)NÃO");
                    input =readInt("->",2);
                    if(input == 1){
                        //Jogador bebe a poção
                        player.hp = player.maxHp;
                        clearConsole();
                        printHeading("Voce bebeu a poção e restaurou totalmente seu Hp");
                        anythingToContinue();
                    }
                }else{
                    //Jogador nao pode usar poção
                }

            }else{
                clearConsole();
                //chance de fuga de 35%
                //Checar se jogar nao esta no chefe final
                if(act!=4){
                    if(Math.random()*10+1<=3.5){
                        printHeading("Voce conseguiu fugiu " +enemy.name);
                        anythingToContinue();
                        break;
                    }else {

                        System.out.println("Voce nao conseguiu fugir");
                        //Calculo de dnao que o jogador recebeu
                        int dmgTook = enemy.ataque();
                        player.hp -= dmgTook;
                        System.out.println("Voce recebeu "+dmgTook+" de dano!");
                        anythingToContinue();
                        //checar se jogador esta vivo
                        if(player.hp <= 0){
                            playerDied();
                        }
                    }
                }else{
                    printHeading("VOCE NÂO PODE FUGIR DO MALVADO IMPERADOR!!!");
                    anythingToContinue();
                }
            }
        }
    }

    public static void printMenu(){
        clearConsole();
        printHeading(places[place]);
        System.out.println("Escolhe uma opção:");
        printSeparator(20);
        System.out.println("(1) - Continuar a aventura");
        System.out.println("(2) - Informação do personagem");
        System.out.println("(3) - Sair do Jogo");;
    }

    public static void finalBattle(){
        //criação do chefe final
        battle(new Enemy("IMPERADOR MALVADO",300));
        //historia
        Historia.printFourthActOutro(player);
        isRunning =  false;
    }

    //metodo quando vida do jogador chega a zero
    public static void playerDied(){
        clearConsole();
        printHeading("Voce morreu...");
        printHeading("Voce ganhou "+player.xp+ "XP em sua jornada. Tente novamente para ganhar mais");
        System.out.println("Obrigado por jogar. Espero que tenha gostado");
        isRunning = false;
    }

    public static void gameLoop(){
        while(isRunning){
            printMenu();
            int input = readInt("->",3);
            if(input == 1)
                continueJourney();
             else if (input == 2)
                characterInfo();
            else
                isRunning = false;
        }
    }
}
