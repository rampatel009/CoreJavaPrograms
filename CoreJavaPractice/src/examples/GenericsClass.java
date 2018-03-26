package examples;

import java.util.List;

public class GenericsClass<T, U> {
    T obj1;  // An object of type T
    U obj2;  // An object of type U

    // constructor
    public GenericsClass(T obj1, U obj2)
    {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    // To print objects of T and U
    public void print()
    {
        System.out.println(obj1);
        System.out.println(obj2);
    }

    // A Generic method example
    public static <T> void genericDisplay (T element)
    {
        System.out.println(element.getClass().getName() + " = " + element);
    }

    public static double sum(List<? extends Number> list)
    {
        double sum=0.0;
        //Using forEach
        for (Number i: list)
        {
            sum+=i.doubleValue();
        }
        return sum;
    }

    public static void printOnlyIntegerClassorSuperClass(List<? super Integer> list)
    {
        System.out.println(list);
    }

    public static void printList(List<?> list)
    {
        System.out.println(list);
    }
}
