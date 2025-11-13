# -*- coding: utf-8 -*-
"""
Fibonacci con función Generator versión 2

Calcula hacia adelante

Tema: yield
La sentencia yield suspende la ejecución de una función y devuelve un valor al invocador, pero conserva suficiente estado para que la 
función pueda reanudarse donde la dejó. Cuando la función se reanuda, continúa la ejecución inmediatamente después de la última ejecución 
de yield. Esto permite que su código genere una serie de valores a lo largo del tiempo, en lugar de calcularlos de una vez y devolverlos
como una lista.
      
if __name__ == "__main__":
    Sirve para ejecutar un bloque de código solo cuando el script se ejecuta directamente, y no cuando se importa 
    como un módulo en otro archivo.

Versión adaptada del material del Prof. Roberto Méndez Méndez

Software: Python (implementado en GitHub)

Repositorio:  https://github.com/cynthia04-code/fibonacci_replicas.py/tree/main

Probar codigo en:https://www.jdoodle.com/python3-programming-online

Editores: Ciros Ortíz Diego
          Isauro Trinidad Cynthia 
          Soto Álvarez Regina 
          
Creado:  06 / 11 / 2025
Editado: 08 / 11 / 2025
"""
from typing import Generator

def fibGen(n: int) -> Generator[int, None, None]:
    """Genera los valores de la secuencia de Fibonacci hasta la posición n."""
    if n < 0:
        raise ValueError("El número debe ser un entero no negativo.")

    yield 0
    if n > 0:
        yield 1

    penultimo: int = 0
    ultimo: int = 1
    for _ in range(1, n):
        penultimo, ultimo = ultimo, penultimo + ultimo
        yield ultimo


if __name__ == "__main__":
    try:
        n = int(input("¿Hasta qué posición deseas generar Fibonacci?: "))
        if n < 0:
            print("Por favor, ingresa un número entero no negativo.")
        else:
            print(f"Secuencia de Fibonacci hasta {n}:")
            for valor in fibGen(n):
                print(valor, end=" ")
            print()
    except ValueError:
        print("Error: Debes ingresar un número entero válido.")
