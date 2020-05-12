import examples.GenericsClass;
import examples.Java8Example;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //random code for practice
        Java8Example.randomCode();

        // Core java 5 Generics examples Test changes
        callGenericsMethod();
        System.out.println();

        System.out.println("****  Java 8 Optional   ****");
        Java8Example oe = new Java8Example();
        oe.runOptionalExamples();
        System.out.println("****  Java 8 Optional end  ****");
        System.out.println();

        //Test 1
        //Test 2
        //Test 3

        System.out.println("****  Java 8 Streams   ****");;
        oe.runStreamsExamples();
        System.out.println("****  Java 8 Streams end  ****");
        System.out.println();

        System.out.println("****  Java 8 Functional programming ****");;
        oe.functionalProgramming();
        System.out.println("****  Java 8 Functional programming end  ****");
        System.out.println();
		// Core java 5 Generics examples end 

    }

    private static void callGenericsMethod() {
        GenericsClass<String, Integer> obj = new GenericsClass<String, Integer>("Generic class test", 111);
        obj.print();

        System.out.println("****Generic function****");
        GenericsClass.genericDisplay(10);
        GenericsClass.genericDisplay("Generic method value");
        GenericsClass.genericDisplay(1.0);
        System.out.println("****Generic function end ****");

        System.out.println("****Upper Bounded Wildcards****");
        //Upper Bounded Integer List
        List<Integer> list1= Arrays.asList(4,5,6,7);
        //printing the sum of elements in list
        System.out.println("Total sum is:"+GenericsClass.sum(list1));
        //Double list
        List<Double> list2= Arrays.asList(4.1,5.1,6.1);
        //printing the sum of elements in list
        System.out.println("Total sum is:"+GenericsClass.sum(list2));
        System.out.println("****Upper Bounded Wildcards End****");

        System.out.println("****Lower Bounded Wildcards****");
        GenericsClass.printOnlyIntegerClassorSuperClass(list1);
//        GenericsClass.printOnlyIntegerClassorSuperClass(list2); error as double is at higher level than integer
        System.out.println("****Lower Bounded Wildcards End****");

        System.out.println("****Un Bounded Wildcards****");
        GenericsClass.printList(list1);
        GenericsClass.printList(list2);
        System.out.println("****Un Bounded Wildcards End****");
    }
}
