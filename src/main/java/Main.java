import org.jooq.lambda.Seq;

import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.iterate(1, i -> i + 1);
        Seq<String> fizzes = Seq.cycle(Arrays.asList("", "", "Fizz"));
        Seq<String> buzzes = Seq.cycle(Arrays.asList("", "", "", "", "Buzz"));
        Seq<String> fizzesAndBuzzes = fizzes.zip(buzzes, (a, b) -> a + b);
        Seq<? extends Serializable> zip = fizzesAndBuzzes.zip(numbers, (a, b) -> a.isEmpty() ? b : a);
        zip.take(30).forEach(System.out::println);
    }
}
