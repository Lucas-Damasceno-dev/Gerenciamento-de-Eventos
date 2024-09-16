package vendaingressos;

import java.util.Date;
import java.util.Objects;

/**
 * A classe Ingresso representa um ingresso para um determinado evento.
 * Ela contém informações sobre o evento, preço, assento, e se o ingresso está ativo ou não.
 */
public class Ingresso {

    // Atributos
    /**
     * O evento para o qual o ingresso foi adquirido.
     */
    private final Evento evento;

    /**
     * O preço do ingresso.
     */
    private final float preco;

    /**
     * O assento designado para o ingresso.
     */
    private final String assento;

    /**
     * Indica se o ingresso está ativo (válido) ou não.
     */
    private boolean isAtivo;

    // Construtor
    /**
     * Constrói um novo Ingresso com o evento, preço e assento fornecidos.
     * O ingresso é criado como ativo por padrão.
     *
     * @param evento O evento associado ao ingresso.
     * @param preco O preço do ingresso.
     * @param assento O assento designado.
     */
    public Ingresso(Evento evento, float preco, String assento) {
        this.evento = evento;
        this.preco = preco;
        this.assento = assento;
        this.isAtivo = true;
    }

    // Getters
    /**
     * Obtém o evento associado ao ingresso.
     *
     * @return O evento do ingresso.
     */
    public Evento getEvento() {
        return evento;
    }

    /**
     * Obtém o preço do ingresso.
     *
     * @return O preço do ingresso.
     */
    public float getPreco() {
        return preco;
    }

    /**
     * Obtém o assento designado para o ingresso.
     *
     * @return O assento do ingresso.
     */
    public String getAssento() {
        return assento;
    }

    /**
     * Verifica se o ingresso está ativo.
     *
     * @return {@code true} se o ingresso estiver ativo, {@code false} caso contrário.
     */
    public boolean isAtivo() {
        return isAtivo;
    }

    // Métodos Sobrescritos
    /**
     * Compara dois objetos Ingresso para verificar se são iguais, com base no evento, preço, assento e estado de atividade.
     *
     * @param o O objeto a ser comparado.
     * @return {@code true} se os objetos forem iguais, {@code false} caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingresso ingresso = (Ingresso) o;
        return Float.compare(preco, ingresso.preco) == 0 && isAtivo == ingresso.isAtivo &&
                Objects.equals(evento, ingresso.evento) && Objects.equals(assento, ingresso.assento);
    }

    /**
     * Retorna o código hash para o objeto Ingresso, baseado nos atributos evento, preço, assento e estado de atividade.
     *
     * @return O código hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(evento, preco, assento, isAtivo);
    }

    /**
     * Retorna uma representação em string do objeto Ingresso.
     *
     * @return Uma string contendo os detalhes do ingresso.
     */
    @Override
    public String toString() {
        return "Ingresso{" +
                "evento=" + evento +
                ", preco=" + preco +
                ", assento='" + assento + '\'' +
                ", isAtivo=" + isAtivo +
                '}';
    }

    // Métodos da Classe
    /**
     * Cancela o ingresso se ele estiver ativo e o evento ainda não tiver ocorrido.
     *
     * @return {@code true} se o ingresso foi cancelado com sucesso, {@code false} caso contrário.
     */
    public boolean cancelar() {
        if (isAtivo && evento.getData().after(new Date())) {
            isAtivo = false;
            return true;
        }
        return false;
    }

    /**
     * Reativa o ingresso, se ele estiver inativo.
     */
    public void reativar() {
        if (!isAtivo) {
            isAtivo = true;
        }
    }
}
