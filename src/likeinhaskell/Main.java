package likeinhaskell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
   public static void main(String[] args) {
      List<Integer> list = Arrays.asList(1, 2, 4, 5, 6, 1, 5, 6);

      System.out.println(partition(list, x -> x < 4));

      Function<Integer, Integer> inc = i -> i + 1;
      Function<Integer, Integer> thrice = inc.compose(inc).compose(inc);

      System.out.println(thrice.apply(3));

      Either<Integer, String> divZero = div(6, 0);

      System.out.println(divZero);

      System.out.println(divZero.either(inc, r -> 42));

//      Animal[] carr = new Cat[10];
//      carr[0] = new Dog();
   }

   static <A> Tuple<List<A>, List<A>> partition(List<A> list, Function<A, Boolean> p) {
      List<A> xs = new ArrayList<>();
      List<A> ys = new ArrayList<>();

      for (A item : list)
         if (p.apply(item))
            xs.add(item);
         else
            ys.add(item);

      return new Tuple<>(xs, ys);
   }

   static <A> List<A> filter(List<A> list, Function<A, Boolean> p) {
      return partition(list, p).fst();
   }

   public static Either<Integer, String> div(Integer x, Integer y) {
      return y == 0 ? Either.right("Division by zero!")
                    : Either.left(x / y);
   }
}

class AddOne implements Function<Integer, Integer> {
   @Override
   public Integer apply(Integer input) {
      return input + 1;
   }
}