// Se usará un Hashtable<Long, Long> para almacenar los resultados:

import java.util.Hashtable;

public class FibonacciThreadsLong implements Runnable {
  long fi;
  int num;

  private static Hashtable<Integer, Long> memo = new Hashtable<>();
  public FibonacciThreadsLong(int n, long f) {
    num = n;
    fi = f;
  }  
  @Override
  public void run() {
    // ... (código existente)
    long res = fibonacci(fi);
  }
  long fibonacci(long f) {
    if (f<2)
    return 1;

    // Verifica si el valor ya fue calculado
    if (memo.conatainsKey(f)){
        return memo.get(f);
    }

    // Calcula el valor 
    long result = fibonacci(f-1) + fibonacci(f-2);

    // Almacena en la tabla hash
    memo.put(f, result);
    return result;
  }
  // ... (rest of the class)
}