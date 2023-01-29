<br>
<h1 align="center">
	Calculadora Alticci Sequence
</h1>
<br>

## Sobre o repositório

REST service, using a JAVA framework, returning a value from the Alticci sequence.

The Alticci – a(n) - sequence is defined as follows:

n=0 => a(0) = 0

n=1 => a(1) = 1

n=2 => a(2) = 1

n>2 => a(n) = a(n-3) + a(n-2)



## Pré-requisitos para execução do projeto

* Java 17
* Maven

## Como utilizar?


Executar o projeto, o Swagger estará no link:

[Swagger](http://localhost:8080/swagger-ui/index.html#/)

Uma GUI html com javascript está co caminho alticci-sequence/src/main/resources/gui.html, abrir o ficheiro no navegador e clicar em Calculate.

Foi criado testes unitários apenas para o service SequenceService.


---
