package vendaingressos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * A classe Controller gerencia os eventos, usuários e suas interações, como o cadastro de eventos, compra e cancelamento de ingressos.
 */
public class Controller {

    // Atributos
    /**
     * Lista de eventos gerenciados pelo controlador.
     */
    private final ArrayList<Evento> eventos;

    // Construtor
    /**
     * Constrói um novo Controller inicializando a lista de eventos.
     */
    public Controller() {
        this.eventos = new ArrayList<>();
    }

    // Métodos Sobrescritos
    /**
     * Compara este objeto Controller com outro objeto para verificar se são iguais, com base na lista de eventos.
     *
     * @param o O objeto a ser comparado.
     * @return {@code true} se os objetos forem iguais, {@code false} caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Controller that = (Controller) o;
        return Objects.equals(eventos, that.eventos);
    }

    /**
     * Retorna o código hash para o objeto Controller, baseado na lista de eventos.
     *
     * @return O código hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(eventos);
    }

    // Métodos da Classe
    /**
     * Cadastra um novo usuário no sistema.
     *
     * @param login O login do usuário.
     * @param senha A senha do usuário.
     * @param nome O nome do usuário.
     * @param cpf O CPF do usuário.
     * @param email O email do usuário.
     * @param isAdmin Indica se o usuário é administrador.
     * @return O objeto {@link Usuario} recém-cadastrado.
     */
    public Usuario cadastrarUsuario(String login, String senha, String nome, String cpf, String email, boolean isAdmin) {
        return new Usuario(login, senha, nome, cpf, email, isAdmin);
    }

    /**
     * Cadastra um novo evento no sistema, caso o usuário seja um administrador.
     *
     * @param usuario O usuário que está tentando cadastrar o evento.
     * @param nome O nome do evento.
     * @param descricao A descrição do evento.
     * @param data A data do evento.
     * @return O objeto {@link Evento} recém-cadastrado.
     * @throws SecurityException Se o usuário não for administrador.
     */
    public Evento cadastrarEvento(Usuario usuario, String nome, String descricao, Date data) {
        if (usuario.isAdmin()) {
            Evento evento = new Evento(nome, descricao, data);
            eventos.add(evento);
            return evento;
        } else {
            throw new SecurityException("Somente administradores podem cadastrar eventos.");
        }
    }

    /**
     * Adiciona um assento disponível a um evento específico.
     *
     * @param nome O nome do evento.
     * @param assento O assento a ser adicionado.
     */
    public void adicionarAssentoEvento(String nome, String assento) {
        for (Evento evento : eventos) {
            if (evento.getNome().equals(nome)) {
                evento.adicionarAssento(assento);
            }
        }
    }

    /**
     * Realiza a compra de um ingresso para um usuário, removendo o assento do evento e adicionando o ingresso à lista do usuário.
     *
     * @param usuario O usuário que está comprando o ingresso.
     * @param nome O nome do evento.
     * @param assento O assento escolhido para o ingresso.
     * @return O objeto {@link Ingresso} recém-comprado.
     * @throws IllegalArgumentException Se o assento não estiver disponível ou se o evento não for encontrado.
     */
    public Ingresso comprarIngresso(Usuario usuario, String nome, String assento) {
        for (Evento evento : eventos) {
            if (evento.getNome().equals(nome) && !evento.getAssentosDisponiveis().contains(assento)) {
                throw new IllegalArgumentException("Assento indisponível.");
            } else {
                Ingresso ingresso = new Ingresso(evento, 100.0F, assento);
                evento.removerAssento(assento);
                usuario.getIngressos().add(ingresso);
                return ingresso;
            }
        }
        throw new IllegalArgumentException("Evento não encontrado.");
    }

    /**
     * Cancela a compra de um ingresso de um usuário, reativando o assento no evento correspondente.
     *
     * @param usuario O usuário que está cancelando a compra.
     * @param ingresso O ingresso a ser cancelado.
     * @return {@code true} se o cancelamento foi bem-sucedido, {@code false} caso contrário.
     */
    public boolean cancelarCompra(Usuario usuario, Ingresso ingresso) {
        if (usuario.getIngressos().contains(ingresso)) {
            usuario.getIngressos().remove(ingresso);
            ingresso.cancelar();
            ingresso.getEvento().adicionarAssento(ingresso.getAssento());
            return true;
        }
        return false;
    }

    /**
     * Lista todos os eventos disponíveis, ou seja, eventos que ainda não ocorreram.
     *
     * @return Uma lista de eventos disponíveis.
     */
    public List<Evento> listarEventosDisponiveis() {
        List<Evento> eventosDisponiveis = new ArrayList<>();
        for (Evento evento : eventos) {
            if (evento.isAtivo()) {
                eventosDisponiveis.add(evento);
            }
        }
        return eventosDisponiveis;
    }

    /**
     * Lista todos os ingressos comprados por um usuário.
     *
     * @param usuario O usuário cujos ingressos serão listados.
     * @return Uma lista de ingressos comprados pelo usuário.
     */
    public List<Ingresso> listarIngressosComprados(Usuario usuario) {
        return usuario.getIngressos();
    }
}
