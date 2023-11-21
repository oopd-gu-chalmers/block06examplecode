package likeinhaskell;

/**
 * Created by Niklas on 2016-02-07.
 */
// TODO task 1: Implement this class. It should act like a tuple in e.g.
//  Haskell or Python. An object of this type should hold two values of
//  (possibly) different (arbitrary) types, and have the methods fst()
//  and snd() to return the respective components.
//  NOTE: The class should be read-only after initial construction.
public class Tuple<A, B> {
   private final A fst;
   private final B snd;

   public Tuple(A fst, B snd) {
      this.fst = fst;
      this.snd = snd;
   }

   public A fst() {
      return fst;
   }

   public B snd() {
      return snd;
   }

   @Override
   public String toString() {
      return "(" + fst + "," + snd + ")";
   }
}
