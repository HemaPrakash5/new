import java.util.*;
public class Methods
{
    public static void D()
    {
        System.out.println("Method in D");
    }
    public static void C()
    {
        System.out.println("Method in C");
    }
    public static void B()
    {
        C();
        System.out.println("Method in B");
    }
    public static void A()
    {
        B();
        System.out.println("Method in A");
    }
    public static void main(String args[])
    {
        A();
        D();
    }
}