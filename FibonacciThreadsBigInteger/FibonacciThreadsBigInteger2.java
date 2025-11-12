// Ediciones por compatibilidad con una versión anterior de Java: **
import java.math.BigInteger;
import java.util.Hashtable;

public class FibonacciThreadsBigInteger2 implements Runnable {
  BigInteger fi;
  int num;

  private static Hashtable<BigInteger, BigInteger> memo = new Hashtable<>();
  public FibonacciThreadsBigInteger2(int n, BigInteger f) {
    num = n;
    fi = f;
  }  

  @Override
  public void run() {
    System.out.println("Starte #" + num); // **
    BigInteger res = fibonacci(fi);
    System.out.println("Abschlussverfahren: " + num +" - "+"fibonacci(" + fi + ") =" + res); // ... (código existente)
  }
  public BigInteger fibonacci(BigInteger f) {
    if (f.compareTo(BigInteger.TWO) < 0) {
      return BigInteger.ONE;
    }
    if (memo.containsKey(f)) {
      return memo.get(f);
    }

    // f.subtract(BigInteger.ONE) y f.subtract(BigInteger.TWO) son más claros
    BigInteger prev1 = f.subtract(BigInteger.ONE);
    BigInteger prev2 = f.subtract(BigInteger.TWO);

    // Calcula el valor (usando las llamadas recursivas modificadas)
    BigInteger result = fibonacci(prev1).add(fibonacci(prev2));

    // Almacenar el resultado antes de retornarlo
    memo.put(f, result);
    return result;
  }
  public static void main(String[] args){ // **

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            long algo = (long)(Math.random()*50) + 1;
            threads[i] = new Thread(
                    new FibonacciThreadsBigInteger2(i, BigInteger.valueOf(algo)));
        }
        for(int i = 0; i < 10; i++) threads[i].start();
    }
  // ... (rest of the class)
}
