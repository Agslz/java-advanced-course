package models;

public class Enemy {

    protected Double health;
    protected Integer posX;

    public Enemy(Double health, Integer posX, Integer posY) {
        this.health = health;
        this.posX = posX;
        this.posY = posY;
    }

    public Enemy() {
    }

    public Double getHealth() {
        return health;
    }

    public void setHealth(Double health) {
        this.health = health;
    }

    public Integer getPosX() {
        return posX;
    }

    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }

    protected Integer posY;

}
