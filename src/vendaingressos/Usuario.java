package vendaingressos;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A classe Usuario representa um usuário do sistema de venda de ingressos.
 * Ela armazena informações como login, nome, CPF, email, senha, status de administrador
 * e ingressos adquiridos pelo usuário.
 */
public class Usuario {

    // Atributos
    /**
     * O login do usuário. Campo final, não pode ser alterado.
     */
    private final String login;

    /**
     * O nome completo do usuário.
     */
    private String nome;

    /**
     * O CPF do usuário.
     */
    private String cpf;

    /**
     * O email do usuário.
     */
    private String email;

    /**
     * A senha do usuário.
     */
    private String senha;

    /**
     * Indica se o usuário possui privilégios de administrador.
     */
    private final boolean isAdmin;

    /**
     * Lista de ingressos adquiridos pelo usuário.
     */
    private final ArrayList<Ingresso> ingressos;

    // Construtor
    /**
     * Constrói um novo objeto Usuario com os dados fornecidos.
     *
     * @param login O login do usuário.
     * @param senha A senha do usuário.
     * @param nome O nome completo do usuário.
     * @param cpf O CPF do usuário.
     * @param email O email do usuário.
     * @param isAdmin Indica se o usuário é administrador.
     */
    public Usuario(String login, String senha, String nome, String cpf, String email, boolean isAdmin) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.isAdmin = isAdmin;
        this.ingressos = new ArrayList<>();
    }

    // Getter's and Setter's
    /**
     * Obtém o nome do usuário.
     *
     * @return O nome do usuário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do usuário.
     *
     * @param nome O novo nome do usuário.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o CPF do usuário.
     *
     * @return O CPF do usuário.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF do usuário.
     *
     * @param cpf O novo CPF do usuário.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Obtém o email do usuário.
     *
     * @return O email do usuário.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do usuário.
     *
     * @param email O novo email do usuário.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o login do usuário.
     *
     * @return O login do usuário.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Define a senha do usuário.
     *
     * @param senha A nova senha do usuário.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Verifica se o usuário possui privilégios de administrador.
     *
     * @return {@code true} se o usuário for administrador, {@code false} caso contrário.
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Obtém a lista de ingressos adquiridos pelo usuário.
     *
     * @return A lista de ingressos.
     */
    public ArrayList<Ingresso> getIngressos() {
        return ingressos;
    }

    // Métodos Sobrescritos
    /**
     * Verifica a igualdade entre dois objetos Usuario com base em login, CPF e email.
     *
     * @param obj O objeto a ser comparado.
     * @return {@code true} se os objetos forem iguais, {@code false} caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Usuario usuario = (Usuario) obj;
        return login.equals(usuario.login) && cpf.equals(usuario.cpf) && email.equals(usuario.email);
    }

    /**
     * Retorna o código hash baseado nos atributos do usuário.
     *
     * @return O valor do hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf, email, login, senha, isAdmin, ingressos);
    }

    /**
     * Retorna uma representação textual do objeto Usuario.
     *
     * @return Uma string contendo os atributos do usuário.
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", isAdmin=" + isAdmin +
                ", ingressos=" + ingressos +
                '}';
    }

    // Métodos da Classe
    /**
     * Verifica se as credenciais de login e senha fornecidas são válidas.
     *
     * @param login O login fornecido.
     * @param senha A senha fornecida.
     * @return {@code true} se as credenciais estiverem corretas, {@code false} caso contrário.
     */
    public boolean login(String login, String senha) {
        return Usuario.this.login.equals(login) && Usuario.this.senha.equals(senha);
    }
}
