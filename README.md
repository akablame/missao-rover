# Missão Rover Marte

Projeto desenvolvido durante as aulas práticas do Curso Técnico em Desenvolvimento de Sistemas no SENAI.

A proposta era criar um simulador em Java executado no console, onde o jogador controla um Rover em solo marciano e precisa chegar até a base de comando administrando energia e integridade do casco.

## Sobre o projeto

O Rover inicia na posição `(0,0)` e a base é gerada dinamicamente em outra coordenada do mapa.

Durante o trajeto, o jogador precisa lidar com eventos aleatórios, terrenos hostis e gerenciamento de recursos.

## Funcionalidades

- Movimentação via teclado (`W`, `A`, `S`, `D`)
- Sistema de energia e vida
- Radar com cálculo da distância até a base
- Eventos aleatórios durante a missão
- Tipos de terreno:
  - Comum (sem efeitos aplicados)
  - Arenoso (maior consumo de energia)
  - Rochoso (causa dano)
- Base gerada aleatoriamente a cada partida

## Tecnologias utilizadas

- Java
- Programação Orientada a Objetos
- Classe Random
- Math.sqrt()
- Math.pow()

## Estrutura

```
src/
├── Main.java
└── Rover.java
```

## Como executar

```bash
git clone https://github.com/akablame/missao-rover.git
cd missao-rover/src
javac Main.java Rover.java
java Main
```

## Aprendizados

- lógica de programação
- estruturas de repetição
- condicionais
- organização em classes
- interação no console
- aplicação de matemática em código real

## Autor

Maicon Ventura
