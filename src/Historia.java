public class Historia {

    public static void printIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("=====VILA DO COMEÇO====");
        GameLogic.printSeparator(30);
        System.out.println("Voce é o último sobrevivente da sua aldeia que foi invadida " +
                "pelo malvado Imperador.\nTodos que voce conhecia tiveram suas vidas tomadas" +
                "\nAgora tudo que voce quer é uma chance de vingança!Por agora voce inicia a sua jornada para derrotar " +
                "o malvado Imperador e libertar as terras tomadas pelo terror de seu dominio");
        GameLogic.anythingToContinue();
    }

    public static void printFirstActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("=====MONTANHAS SEM FIM====");
        GameLogic.printSeparator(30);
        System.out.println("Você começa sua jornada atravesando as montanhas sem fim. " +
                "\nEssas montanhas são conhecidas por diversos perigos e nenhum ser vivo voltou vivo daquele lugar" +
                "\nApos uma longa caminhada pela floresta voce chega as montanhas, e nao importa o perigo voce esta decidido a arriscar qualque coisa pelo seu objetivo");
        GameLogic.anythingToContinue();
    }

    public static void printFirstActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("=====MONTANHAS SEM FIM====");
        GameLogic.printSeparator(30);
        System.out.println("Voce conseguiu! Voce atravessou a montanhaa sem fim com vida!\n" +
                "Voce desce o ultimo vale, voce suspira mais uma vez satisfeito com o sucesso de cruzar essas perigosas montanhas!");
    GameLogic.anythingToContinue();
    }

    public static void printSecondActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("=====PLANICIES DESOLADAS====");
        GameLogic.printSeparator(30);
        System.out.println("Voce começa a cruzar as retas planicies desoladas que uma vez foi o interior populoso do pais." +
                "\nVoce coletou algum ouro dos monstros que voce derrotou pelo caminho." +
                "\nPor sorte voce encontou um mercador pelo caminho.");
        System.out.println("Voce sabe exatamente onde é o castelo do imperador malvado, mas voce precisa cruzar as planicies desoladas. ");
    GameLogic.anythingToContinue();
    }

    public static void priprintSecondActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("=====PLANICIES DESOLADAS====");
        GameLogic.printSeparator(30);
        System.out.println("Você conseguiu atravessar as planicies assombradas.");
        System.out.println("Você esta a algumas horas do seu destino final. O castelo do Imperador malvado.");
        System.out.println("Você sabe que nao ira conseguir descansar por la, você resolve sentar perto de uma árvore na beirada da trilha para descansar.");
        System.out.println("\nEnquanto descansava voce refletia sobre algumas de suas tecnicas e voce acabou aprimorando mais uma delas.");
        GameLogic.anythingToContinue();
    }

    public static void printThirdActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("=====CASTELO DO IMPERADOR MALVADO====");
        GameLogic.printSeparator(30);
        System.out.println("Você de depara com o gigantesco castelo negro a uma dezena de metros.");
        System.out.println("Você para em frente ao grande portao sabendo que nao tera como voltar.");
        System.out.println("Você se se disfarça como mercenario para entrar no castelo, Você não sabe quanto tempo tera ate ser descoberto.");
        System.out.println("Tudo que voce sabe é lutar e rezar que saira vitorioso...");
        GameLogic.anythingToContinue();
    }

    public static void printThirdActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("=====CASTELO DO IMPERADOR MALVADO====");
        GameLogic.printSeparator(30);
        System.out.println("Você chegou longe. Voce derrotou todos os capangas do Imperador Malvado.");
        System.out.println("A sua frente esta o  portão que leva a sala do trono.");
        System.out.println("Você encosta na coluna proxima ao portão para descansar.");
        System.out.println("Você se sente um pouco mais forte e percebe que pode pode melhorar uma de suas tecnicas.");
        GameLogic.anythingToContinue();
    }

    public static void printFourthActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("=====SALA DO TRONO====");
        GameLogic.printSeparator(30);
        System.out.println("Você entra no salão do trono do malvado Imperador.");
        System.out.println("Você encara seus olhos cheios de morte. Voce sente que a escuridao o rodeia.");
        System.out.println("Ele puxa sua gigantesca espada negra dentada.");
        System.out.println("Tudo que voce sabe que tera que dar o seu melhor para ter alguma chance de vencer...");
        GameLogic.anythingToContinue();
    }

    public static void printFourthActOutro(Player player){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Parabens "+ player.name+"! Voce derrotou o malvado Imperador e salvou o mundo!!");
        GameLogic.printSeparator(30);
        System.out.println("a elFihr production");
        System.out.println("Esperamos que tenha se divertido!");
        GameLogic.anythingToContinue();
    }
}
