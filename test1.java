import java.util.Scanner;
public class test1 {
    public static void main(String []args)
    {
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
        int i3,sum=0;
        for(i3=1;i3<=x;i3++)
        {
            MyThread t=new MyThread();
            flag.flag1=0;
            t.start();
            if(flag.flag1==1)
            {
                sum+=i3;
            }
        }
        System.out.println(sum);
    }
}
class flag
{
    public static int flag1;
    public flag(){}
}
class MyThread extends Thread
{
    public void run(int x11)
    {
        while(x11>0)
        {
            int y1;y1=x11%10;
            if(y1==9)
            {
                flag.flag1=1;return;
            }
        }
        flag.flag1=0;return;
    }
    MyThread(){}
}