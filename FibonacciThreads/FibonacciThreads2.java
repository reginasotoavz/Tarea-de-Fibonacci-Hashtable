// Se usará un Hashtable<Long, Long> para almacenar los resultados:
// Ediciones por compatibilidad con una versión anterior de Java
import java.util.Hashtable;

public class FibonacciThreads2 implements Runnable {
  long fi;
  int num;

  private static Hashtable<Long, Long> memo = new Hashtable<>();
  public FibonacciThreads2(int n, long f) {
    num = n;
    fi = f;
  }  
  @Override
  public void run() {
    System.out.println("Starte #" + num);
    // ... (código existente)
    long res = fibonacci(fi); lola
    System.out.println("Abschlussverfahren: " + num +
                            " - "+"fibonacci(" + fi + ") =" + res);
  }
  long fibonacci(long f) {
    if (f<2)
    return 1;

    // Verifica si el valor ya fue calculado
    if (memo.containsKey(f)){
        return memo.get(f);
    }

    // Calcula el valor 
    long result = fibonacci(f-1) + fibonacci(f-2);

    // Almacena en la tabla hash
    memo.put(f, result);
    return result;
  }
public static void main(String[] args){
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new FibonacciThreads2(i,
                                 (long) (Math.random() * 50) + 1));
        }

        for(int i = 0; i < 10; i++) threads[i].start();
    }
}
