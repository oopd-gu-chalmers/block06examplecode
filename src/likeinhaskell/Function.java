package likeinhaskell;

/**
 * Created by Niklas on 2016-02-07.
 */
// TODO task 3: For more challenge!
//  Implement this interface. An object of this type should represent a
//  function with some arbitrary parameter type T and arbitrary return type R.
//  The interface should have the methods apply(), which applies the
//  represented function to an argument of the correct type;
//  and compose(), which takes another Function as argument, and composes
//  "this" function with that other function. Make sure that the return type
//  of the other function matches the expected argument type of this function.
//  .
//  Hint: To solve this task, you need to use type parameters on both the
//  interface itself, *and* on one of its methods

@FunctionalInterface
public interface Function<T, R> {
   R apply(T input);

   // TODO task 5: For even more challenge, really tricky!
   //  Give the compose() function a default implementation.
   default <A> Function<A, R> compose(Function<A, T> g) {
      return x -> apply(g.apply(x));
   }

   // Alternative implementation not using a lambda expression:
   default <A> Function<A, R> comp(Function<A, T> g) {
      Function<T, R> f = this;

      return new Function<A, R>() {
         @Override
         public R apply(A input) {
            return f.apply(g.apply(input));
         }
      };
   }
}
