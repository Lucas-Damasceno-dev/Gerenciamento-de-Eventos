package vendaingressos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * A classe Evento representa um evento que possui nome, descrição, data e uma lista de assentos disponíveis.
 * Ela também contém o estado de atividade do evento, com base na data atual.
 */
public class Evento {

    // Atributos
    /**
     * O nome do evento.
     */
    private final String nome;

    /**
     * A descrição do evento.
     */
    private final String descricao;

    /**
     * A data em que o evento ocorrerá.
     */
    private final Date data;

    /**
     * A lista de assentos disponíveis para o evento.
     */
    private final ArrayList<String> assentosDisponiveis;

    /**
     * Indica se o evento está ativo, ou seja, se ele ainda não ocorreu.
     */
    private final boolean isAtivo;

    // Construtor
    /**
     * Constrói um novo Evento com o nome, descrição e data fornecidos.
     * O evento é marcado como ativo se a data for posterior à data atual.
     *
     * @param nome O nome do evento.
     * @param descricao A descrição do evento.
     * @param data A data do evento.
     */
    public Evento(String nome, String descricao, Date data) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.assentosDisponiveis = new ArrayList<>();
        this.isAtivo = !data.before(new Date());
    }

    // Getters
    /**
     * Obtém o nome do evento.
     *
     * @return O nome do evento.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém a descrição do evento.
     *
     * @return A descrição do evento.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Obtém a data do evento.
     *
     * @return A data do evento.
     */
    public Date getData() {
        return data;
    }

    /**
     * Obtém a lista de assentos disponíveis para o evento.
     *
     * @return Uma lista de assentos disponíveis.
     */
    public List<String> getAssentosDisponiveis() {
        return assentosDisponiveis;
    }

    /**
     * Verifica se o evento está ativo (se ainda não ocorreu).
     *
     * @return {@code true} se o evento estiver ativo, {@code false} caso contrário.
     */
    public boolean isAtivo() {
        return isAtivo;
    }

    // Métodos Sobrescritos
    /**
     * Compara dois objetos Evento para verificar se são iguais, com base no nome, descrição, data, assentos disponíveis e estado de atividade.
     *
     * @param o O objeto a ser comparado.
     * @return {@code true} se os objetos forem iguais, {@code false} caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return isAtivo == evento.isAtivo &&
                Objects.equals(nome, evento.nome) &&
                Objects.equals(descricao, evento.descricao) &&
                Objects.equals(data, evento.data) &&
                Objects.equals(assentosDisponiveis, evento.assentosDisponiveis);
    }

    /**
     * Retorna o código hash para o objeto Evento, baseado nos atributos nome, descrição, data, assentos disponíveis e estado de atividade.
     *
     * @return O código hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, data, assentosDisponiveis, isAtivo);
    }

    /**
     * Retorna uma representação em string do objeto Evento.
     *
     * @return Uma string contendo os detalhes do evento.
     */
    @Override
    public String toString() {
        return "Evento{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                ", assentosDisponiveis=" + assentosDisponiveis +
                ", isAtivo=" + isAtivo +
                '}';
    }

    // Métodos da Classe
    /**
     * Adiciona um assento à lista de assentos disponíveis, se ele ainda não estiver presente.
     *
     * @param assento O assento a ser adicionado.
     */
    public void adicionarAssento(String assento) {
        if (!assentosDisponiveis.contains(assento)) {
            this.assentosDisponiveis.add(assento);
        }
    }

    /**
     * Remove um assento da lista de assentos disponíveis, se ele estiver presente.
     *
     * @param assento O assento a ser removido.
     */
    public void removerAssento(String assento) {
        if (assentosDisponiveis.contains(assento)) {
            this.assentosDisponiveis.remove(assento);
        }
    }
}
