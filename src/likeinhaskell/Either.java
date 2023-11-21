package likeinhaskell;

public abstract class Either<L, R> {
   private static class Left<L, R> extends Either<L, R> {
      private final L val;

      private Left(L val) {
         this.val = val;
      }

      @Override
      public <T> T either(Function<? super L, ? extends T> f, Function<? super R, ? extends T> g) {
         return f.apply(val);
      }
   }

   public static <L, R> Either<L, R> left(L val) {
      return new Left<>(val);
   }

   private static class Right<L, R> extends Either<L, R> {
      private final R val;

      private Right(R val) {
         this.val = val;
      }

      @Override
      public <T> T either(Function<? super L, ? extends T> f, Function<? super R, ? extends T> g) {
         return g.apply(val);
      }
   }

   public static <L, R> Either<L, R> right(R val) {
      return new Right<>(val);
   }

   public abstract <T> T either(Function<? super L, ? extends T> f, Function<? super R, ? extends T> g);

   public boolean isLeft() {
      return either(l -> true, r -> false);
   }

   public boolean isRight() {
      return either(l -> false, r -> true);
   }

   @Override
   public String toString() {
      return either(l -> "Left: " + l, r -> "Right: " + r);
   }

   @Override
   public int hashCode() {
      return either(Object::hashCode, r -> 31 * r.hashCode());
   }

   @Override
   public boolean equals(Object o) {
      if (o == this)
         return true;
      if (o instanceof Either<?, ?>)
         return ((Either<?, ?>) o).either(
               ol -> either(ol::equals, r -> false),
               or -> either(l -> false, or::equals));
      return false;
   }
}
