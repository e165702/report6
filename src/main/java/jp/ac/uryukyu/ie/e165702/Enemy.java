package jp.ac.uryukyu.ie.e165702;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy extends LivingThing{

    Enemy(String name,int hitPoint,int attack) {
        super(name, hitPoint, attack);
    }
    @Override
    public void attack(LivingThing e){
        if(!isDead()) {
            int damage = (int) (Math.random() * getAttack());
            if (damage==0) {
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避\n", getName(), e.getName());
            }else {
                int judge = (int) (Math.random() * 10);
                if (judge <= 1) {
                    System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n", getName(), e.getName(), damage * 2);
                    damage = damage*2;
                } else {
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), e.getName(), damage);
                }
                    e.wounded(damage);

            }
        }
    }
}
