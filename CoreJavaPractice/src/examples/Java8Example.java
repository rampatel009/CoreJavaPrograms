package examples;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Example {

    public void runOptionalExamples() {
        //If Value is not Present
        String[] str = new String[10];
        Optional<String> checkNull1 = Optional.ofNullable(null);
        System.out.println("..." + checkNull1);
        Optional<String> checkNull = Optional.ofNullable(str[5]);
        if (checkNull.isPresent()) {  // check for value is present or not
            String lowercaseString = str[5].toLowerCase();
            System.out.print(lowercaseString);
        } else {
            System.out.println("string value is not present");
        }
        Stream<Integer> intStream = Stream.of(1, 2, 5, 7, 10, 15);
        List<Integer> inList = intStream.collect(Collectors.toList());
//        Optional<Integer> intFilteredList = Optional.of(inList);
//        intFilteredList.filter((i) -> i > 5);

//        Optional<List> checkNull1 = Optional.of(intList);
//        System.out.println("..." + checkNull1);

        //If Value is Present
        str[5] = "JAVA OPTIONAL CLASS EXAMPLE";// Setting value for 5th index
        checkNull = Optional.ofNullable(str[5]);
        if (checkNull.isPresent()) {  // It Checks, value is present or not
            String lowercaseString = str[5].toLowerCase();
            System.out.print(lowercaseString);
        } else {
            System.out.println("String value is not present");
        }

        str = new String[10];
        str[5] = "JAVA OPTIONAL CLASS EXAMPLE";  // Setting value for 5th index
        // It returns an empty instance of Optional class
        Optional<String> empty = Optional.empty();
        System.out.println(empty);
        // It returns a non-empty Optional
        Optional<String> value = Optional.of(str[5]);
        // If value is present, it returns an Optional otherwise returns an empty Optional
        System.out.println("Filtered value: " + value.filter((s) -> s.equals("Abc")));
        System.out.println("Filtered value: " + value.filter((s) -> s.equals("JAVA OPTIONAL CLASS EXAMPLE")));
        // It returns value of an Optional. if value is not present, it throws an NoSuchElementException
        System.out.println("Getting value: " + value.get());
        // It returns hashCode of the value
        System.out.println("Getting hashCode: " + value.hashCode());
        // It returns true if value is present, otherwise false
        System.out.println("Is value present: " + value.isPresent());
        // It returns non-empty Optional if value is present, otherwise returns an empty Optional
        System.out.println("Nullable Optional: " + Optional.ofNullable(str[5]));
        // It returns value if available, otherwise returns specified value,
        System.out.println("orElse: " + value.orElse("Value is not present"));
        System.out.println("orElse: " + empty.orElse("Value is not present"));
        value.ifPresent(System.out::println);   // printing value by using method reference

        Optional<String> nonEmptyGender = Optional.of("male");
        Optional<String> emptyGender = Optional.empty();
        System.out.println("Non-Empty Optional:: " + nonEmptyGender.map(String::toUpperCase));
        System.out.println("Empty Optional    :: " + emptyGender.map(String::toUpperCase));
        Optional<Optional<String>> nonEmptyOptionalGender = Optional.of(Optional.of("male"));
        System.out.println("Optional value   :: " + nonEmptyOptionalGender);
        System.out.println("Optional.map     :: " + nonEmptyOptionalGender.map(gender -> gender.map(String::toUpperCase)));
        System.out.println("Optional.flatMap :: " + nonEmptyOptionalGender.flatMap(gender -> gender.map(String::toUpperCase)));
    }

    public void runStreamsExamples() {
        //Converting Java Stream to Collection or Array
        Stream<Integer> intStream = Stream.of(1, 2, 3, 4);
        List<Integer> intList = intStream.collect(Collectors.toList());
        System.out.println(intList); //prints [1, 2, 3, 4]
        intStream = Stream.of(1, 2, 3, 4); //stream is closed, so we need to create it again
        Map<Integer, Integer> intMap = intStream.collect(Collectors.toMap(i -> i, i -> i + 10));
        System.out.println(intMap); //prints {1=11, 2=12, 3=13, 4=14}
        Stream<Integer> intNumberStream = Stream.of(1, 2, 5, 7, 10, 15);
        List<Integer> inList = intNumberStream.filter(i -> i > 5).collect(Collectors.toList());
        System.out.println(".... : " + inList);
        Stream<Integer> intStream1 = Stream.of(1, 2, 3, 4);
        Integer[] intArray = intStream1.toArray(Integer[]::new);
        System.out.println(Arrays.toString(intArray)); //prints [1, 2, 3, 4]

        //map() to apply functions to an stream
        Stream<String> names = Stream.of("aBc", "d", "ef");
        System.out.println(names.map(s -> {
            System.out.println("Char...:" + s);
            return s.toUpperCase();
        }).collect(Collectors.toList()));
        //prints [ABC, D, EF]

        //sorted() to sort the stream elements by passing Comparator argument.
        Stream<String> names3 = Stream.of("aBc", "d", "ef", "123456");
        List<String> naturalSorted = names3.sorted().collect(Collectors.toList()); // here comparator not reqiured for string
        System.out.println(naturalSorted); //[123456, aBc, d, ef]

        //flatMap() to create a stream from the stream of list
        Stream<List<String>> namesOriginalList = Stream.of(
                Arrays.asList("Pankaj"),
                Arrays.asList("David", "Lisa"),
                Arrays.asList("Amit"));
        //flat the stream from List<String> to String stream
        Stream<String> flatStream = namesOriginalList
                .flatMap(strList -> strList.stream());

        flatStream.forEach(System.out::println);

        //reduce() to perform a reduction on the elements of the stream
        Stream<Integer> numbers = Stream.of(1,2,3,4,5);
        Optional<Integer> intOptional = numbers.reduce((i,j) -> {return i*j;});
        if(intOptional.isPresent()) System.out.println("Multiplication = "+intOptional.get()); //120

        //count()  to count the number of items in the stream
        Stream<Integer> numbers1 = Stream.of(1,2,3,4,5);
        System.out.println("Number of elements in stream="+numbers1.count()); //5

        // foreach for iterating over the stream
        Stream<Integer> numbers2 = Stream.of(1,2,3,4,5);
        numbers2.forEach(System.out::println); //1,2,3,4,5
    }

    public void functionalProgramming() {
        Function<Integer,Integer> add1 = x -> x * 1;
        System.out.println(add1.apply(1));
        Function<Integer,Integer> add2 = Utils::add2;
        System.out.println(add2.apply(2));

        Function<Integer, Function<Integer,Integer>> makeAdder = x -> y -> + 1 ;
        Function<Integer,Integer> add11 = makeAdder.apply(1);
        Function<Integer,Integer> add22 = makeAdder.apply(2);
        Function<Integer,Integer> add33 = makeAdder.apply(3);
        System.out.println(add11.apply(1));
        System.out.println(add22.apply(2));
        System.out.println(add33.apply(3));
    }
}

class Utils {
    public static Integer add2(Integer x) { return x + 1; }
}
