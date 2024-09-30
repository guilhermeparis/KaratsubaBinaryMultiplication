# Karatsuba Binary Multiplication

### Versão do algoritmo de multiplicação de Karatsuba que trabalha com strings.<br>

Como entrada é recebido um número binário em uma string e, recursivamente, são realizadas divisões do número ainda como string.<br>
Os cálculos são feitos apenas quando chega-se a uma string de tamanho 1. Por fim, é retornado o resultado da multiplicação.

* Uso: java Karatsuba <string 1> <string 2>
* Exemplo: java Karatsuba 10101010 11110000
* Saída: 1001111101100000
