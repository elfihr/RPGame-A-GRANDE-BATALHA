public class Enemy extends Character{

    //Metodo estocar xp ogador
    int playerXp;

    //Construtor inimigo
    public Enemy(String name, int playerXp) {
        super(name, (int)(Math.random()*playerXp+playerXp/3+5), (int)(Math.random()*playerXp/4+2)+1);
        this.playerXp =playerXp;
    }
    @Override
    public int ataque() {
        return (int)(Math.random()*(playerXp/4+1)+xp/4+3);
    }

    @Override
    public int defende() {
        return (int)(Math.random()*(playerXp/4+1)+xp/4+3);
    }
}
