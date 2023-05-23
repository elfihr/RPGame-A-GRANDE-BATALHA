
public abstract class Character {

    public String name;
    public int maxHp,hp,xp;

    public Character(String name, int maxHP,int xp) {
        this.name = name;
        this.maxHp = maxHP;
        this.xp = xp;
        this.hp = maxHP;
    }


    public abstract int ataque();
    public abstract int defende();

}
