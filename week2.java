import java.util.Scanner;
import java.util.Iterator;
public class week2 {

}
class LocalDate
{
    private int year;private int month;private int day;
    public LocalDate(int a,int b,int c)
    {
        year=a;month=b;day=c;
    }
    public LocalDate(){}
    public int gety(){return year;}
    public int getm(){return month;}
    public int getd(){return day;}
    public int cal()
    {
        return year*365+month*30+day;
    }
}
abstract class Drinks
{
    protected String name;
    protected double cost;
    protected LocalDate produce;
    protected int exp;
    public Drinks(String m,double n,int q,LocalDate x)
    {
        name=m;cost=n;produce=x;exp=q;
    }
    public Drinks(){}
    public String toString()
    {
        return "NAME: "+name+" COST:"+cost+" EXP: "+exp+" LocalDate: "+produce.gety()+" "+produce.getm()+" "+produce.getd()+" ";
    }
    public int comp(LocalDate x1)/*判断是否过期*/
    {
        int add1=0;int add2=0;
        add1=produce.cal();
        add2=x1.cal();
        if(add1+exp>=add2) return 1;/*没过期，返回1*/
        else return 0;
    }
}
class Beer extends Drinks
{
    float degree;
    public Beer(float x,String m,double n,int q,LocalDate x1)
    {
        super(m,n,2,x1);
        this.degree=x;
    }
    public Beer() {}
}
class Juice extends Drinks
{
    public Juice(String m,double n,int q,LocalDate x1)
    {
        super(m,n,2,x1);
    }
    public Juice() {}
}
class SetMeal/*套餐类*/
{
    private String name1;
    private double price;
    private String chicken;
    public Drinks x;
    public String toString()
    {
       return name1+" "+price+" "+chicken+"\n";
    }
    public void SetMeal(String name,double p,String c,Drinks d)
    {
        name1=name;price=p;chicken=c;x=d;
    }
    public void SetMeal(){}
    public double getprice()
    {
        return price;
    }
}
//自定义异常类
class IngredientSortOutException extends RuntimeException {
    IngredientSortOutException(){
        super();
    }


    public void print() {
        System.out.println("酒水售完");
    }
}
class OverdraftBalanceException extends RuntimeException {
    OverdraftBalanceException(){
        super();
    }


    public void print() {
        System.out.println("进货余额不足");
    }
}
//
interface FriedChickenRestaurant/*炸鸡店接口*/
{
     public abstract void suite();/*出售套餐*/
    public abstract void replenish(SetMeal x1,int shuliang);/*批量进货*/
}
class West2FriedChickenRestauran implements FriedChickenRestaurant/*实现炸鸡店接口*/
{
    private double amount;/*账户余额*/
    private int num1,num2,num3;
    private Beer list1[];
    private Juice list2[];
    public SetMeal list3[];
    private void use(Beer x)
    {
        for(int i=0;i<num1;i++)
        {
            if(x==list1[i])
            {
                for(int j=i+1;j<num1;j++)
                {
                    list1[j-1]=list1[j];
                }
            }
        }
        num1--;
    }
    private void use(Juice x)
    {
        for(int i=0;i<num2;i++)
        {
            if(x==list2[i])
            {
                for(int j=i+1;j<num2;j++)
                {
                    list1[j-1]=list1[j];
                }
            }
        }
        num2--;
    }
    public void suite()/*出售套餐*/
    {
        if(num3==0)
        {
            System.out.println("ERROR");
        }
        else if(num3>0)
        {
            SetMeal y1;y1=list3[0];
            for(int k=1;k<num3;k++)
            {
                list3[k-1]=list3[k];
            }
            amount+=y1.getprice();
            use(y1.x);
        }
    }
    public void replenish(SetMeal x1,int shuliang)/*批量进货*/
    {
        for(int i=0;i<shuliang;i++)
        {
            if(amount<0)
            {
                System.out.println("ERROR");
            }
            else
            {
                if(x1.x instanceof Beer)
                {
                    list1[num1]=x1.x;num1++;
                }
                else if(x1.x instanceof Juice)
                {
                    list2[num2]=x1.x;num2++;
                }
            }
        }
    }
    public West2FriedChickenRestauran()
    {
        amount=0;
        list3=new SetMeal[19];
        list2=new Juice[19];
        list1=new Beer[19];
        list3[0]=SetMeal("Meal1",50.5,"chicken1",Beer(50,"Beer1",22.5,50,LocalDate(2001,1,1)));
        list3[1]=SetMeal("Meal2",50.5,"chicken2",Juice(50,"Juice1",22.5,50,LocalDate(2002,1,1)));
        num3=2;
        num1=0;num2=0;
    }
}

