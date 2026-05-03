// ---------------------- Aqui está a classe Rover que possui todas as funções de movimentação e ações no jogo ----------------------

// Importando a classe Random que permite gerar números aleatórios.
import java.util.Random;

public class Rover {

    // Iniciando o random.
    Random random = new Random();

    // Variaveis
    int x;
    int y;
    int energia;
    int vida;
    int baseX;
    int baseY;
    int energiaMov = 5;

    // Construtor, aqui inicio todas as variaveis do Rover e dou valores iniciais para cada uma.
    public Rover() {
        x = 0;
        y = 0;
        energia = 100;
        vida = 100;
        baseX = random.nextInt(7) + 8; // Gera um número aleatório entre 8 e 14 para a coordenada X da base, deixando um pouco mais dificil de chegar a base.
        baseY = random.nextInt(7) + 8; // Gera um número aleatório entre 8 e 14 para a coordenada Y da base, deixando um pouco mais dificil de chegar a base.
    }

    // Movimentação para cima
    public void movCima() {
        if (energia > 0) {
            y += 1;
            energia -= energiaMov;
        }
    }

    // Movimentação para baixo
    public void movBaixo() {
        if (energia > 0) {
            y -= 1;
            energia -= energiaMov;
        }
    }

    // Movimentação para direita
    public void movDireita() {
        if (energia > 0) {
            x += 1;
            energia -= energiaMov;
        }
    }

    // Movimentação para esquerda
    public void movEsquerda() {
        if (energia > 0) {
            x -= 1;
            energia -= energiaMov;
        }
    }

    // Verifica se o rover chegou na base comparando a coordenada atual com a da base.
    public boolean vitoria() {
        return x == baseX && y == baseY;
    }

    // Calculo da distancia entre o rover e a base
    // Utiliza a fórmula da distância euclidiana
    // Math.sqrt = raiz quadrada
    // Math.pow = potenciação, ou seja:
    // Traduzindo a formula ficaria: (baseX - x)² + (baseY - y)²
    // E então a função retorna o valor da raiz quadrada dessa soma, que é a
    // distância entre o rover e a base
    public double calcularDistancia() {
        return Math.sqrt(
                Math.pow(baseX - x, 2) +
                        Math.pow(baseY - y, 2));
    }

    // Função para exibir o status atual do Rover, mostrando a posição, energia e vida.
    public void status() {
        System.out.println("Posição: (" + x + ", " + y + ")");
        System.out.println("");

        System.out.println("Energia: " + energia);
        System.out.println("");

        System.out.println("Vida: " + vida);
        System.out.println("");

        System.out.printf("Distância para a base: %.2f%n", calcularDistancia());
        System.out.println("");
    }

    // Função para aplicar o dano sofrido pelo Rover
    public void dano(int danoSofrido) {
        if (vida > 0) {
            vida -= danoSofrido;

            if (vida < 0) {
                vida = 0; // Garantindo que a vida não mostre negativada no status após morte.
            }
        }
    }

    // Se a vida ou energia do Rover chegar a 0, a derrota é declarada. Game Over.
    public boolean derrota() {
        return vida <= 0 || energia <= 0;
    }
}
