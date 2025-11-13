# -*- coding: utf-8 -*-
"""
Fibonacci hacia delante

Objetivo: Calcular el valor n-ésimo de la suceción de Fibonacci sin saturar la memoria

Tema: Cálculo de una sucesión recursiva hacia adelante para evitar llamadas redundantes
 
 if __name__ == "__main__":
    Sirve para ejecutar un bloque de código solo cuando el script se ejecuta 
    directamente, y no cuando se importa como un módulo en otro archivo.

Versión adaptada del material del Prof. Roberto Méndez Méndez

Software: Python (implementado en GitHub)

Repositorio: https://github.com/cynthia04-code/fibonacci_replicas.py/tree/main

Probar codigo en: https://www.jdoodle.com/python3-programming-online

Editores: Ciros Ortíz Diego
          Isauro Trinidad Cynthia 
          Soto Álvarez Regina 
          
Creado:  06 / 11 / 2025
Editado: 08 / 11 / 2025
"""
def fibAbel(n: int) -> int:
    if n == 0:
        return n
    penultimo: int = 0
    ultimo: int = 1
    for _ in range(1, n):
        penultimo, ultimo = ultimo, penultimo + ultimo
    return ultimo

if __name__ == "__main__":
    try:
        n = int(input("¿De qué posición quieres el valor de Fibonacci?: "))
        if n < 0:
            print("Ingresar un número entero que no sea negativo.")
        else:
            print(f"El {n}-ésimo valor de Fibonacci es: {fibAbel(n)}")
    except ValueError:
        print("Error: Debes ingresar un número entero.")
