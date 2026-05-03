// ---------------------- Aqui está a classe Main, onde acontece toda a lógica do jogo ----------------------

import java.util.Scanner; // Importa a classe do Scanner.
import java.util.Random; // Importa a classe do Random.

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Inicia o Scanner para leitura de input do usuário.
        Rover rover = new Rover(); // Inicia o Rover, protagonista da parada.
        Random random = new Random(); // Inicia o Random para gerar a tal da aleatoriedade.
        
        while (!rover.vitoria() && !rover.derrota()) {

            // rover.energiaMov = 5; Garantia que o gasto de energia fosse resetado a cada turno, porém, o tipo de terreno já "reseta" o gasto de energia quando é plano, então decidi retirar essa linha.

            rover.status(); // Exibe o status atual do Rover, posição, vida, energia, etc.

            System.out.println("Use W, A, S ou D para mover o Rover");
            System.out.println("");

            System.out.println("W - Cima, A - Esquerda, S - Baixo, D - Direita");
            System.out.println("");

            String comando = scanner.nextLine().toUpperCase(); // Lê o comando do usuario e converte para maiúscula para
                                                               // facilitar a comparação.
            System.out.println("");

            // Movimentação baseado no input inserido
            switch (comando) {
                case "W":
                    rover.movCima();
                    break;

                case "A":
                    rover.movEsquerda();
                    break;

                case "S":
                    rover.movBaixo();
                    break;

                case "D":
                    rover.movDireita();
                    break;

                default:
                    System.out.println("Comando inválido! Use W, A, S ou D!");
                    System.out.println("");
            }

            int terreno = random.nextInt(3); // Ger um numero aleatorio entre 0 e 2 para definir o terreno.

            // Define o tipo de terreno e os efeitos aplicados ao Rover com base no terreno encontrado.
            switch (terreno) {
                case 0:
                    System.out.println("O terreno é comum, tranquilo.");
                    System.out.println("");

                    rover.energiaMov = 5;
                    break;

                case 1:
                    System.out.println("O terreno é arenoso. O gasto de energia dobra!");
                    System.out.println("");

                    rover.energiaMov = rover.energiaMov * 2;
                    break;

                case 2:
                    System.out.println("O terreno é rochoso. O casco perde integridade (menos 10 de vida).");
                    System.out.println("Rover perdeu 10 de vida!");
                    System.out.println("");

                    rover.energiaMov = 5;
                    rover.vida -= 10;
                    break;
            }

            // Simula eventos aleatorios que afetam o Rover.
            int evento = random.nextInt(100); // Gera um número aleatório entre 0 e 99.

            if (rover.vida > 0 && rover.energia > 0) {
                if (evento < 20) { // 20% de chance de encontrar um obstáculo.

                    System.out.println("Você encontrou um obstáculo! Perdeu 10 de vida.");
                    rover.vida -= 10;
                    System.out.println("");

                } else if (evento < 40) { // 20% de chance de encontrar uma fonte de energia.

                    System.out.println("Você encontrou uma fonte de energia! Ganhou 20 de energia.");
                    rover.energia += 20;
                    System.out.println("");

                } else if (evento < 60) { // 20% de chance de encontrar um item de reparo.

                    System.out.println("Você encontrou um item de reparo! Ganhou 15 de vida.");
                    rover.vida += 15;
                    System.out.println("");

                } else if (evento < 80) { // 20% de chance de encontrar um terreno difícil.

                    System.out.println("Você encontrou um terreno difícil! Perdeu 5 de energia.");
                    rover.energia -= 5;
                    System.out.println("");

                } else { // 20% de chance de não acontecer nada.
                    System.out.println("Nada aconteceu, sorte sua!");
                    System.out.println("");
                }

            }

            // Verificação de vitória ou derrota.
            if (rover.vitoria()) {

                System.out.println(
                        "----------------------- Parabéns! Você chegou na base e venceu o jogo! ----------------------");
                System.out.println("");

            } else if (rover.derrota()) {

                System.out.println("Infelizmente, você perdeu. Tente novamente!");
                System.out.println("");
            }
        }
    }
}
