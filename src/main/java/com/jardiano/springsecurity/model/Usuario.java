package com.jardiano.springsecurity.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Funcao> funcaos;

    public Usuario() {
    }

    public Usuario(String nome, String email, String password) {
        this.nome = nome;
        this.email = email;
        this.password = password;
    }

    public Usuario(String nome, String email, String password, Collection<Funcao> funcaos) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.funcaos = funcaos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome(String nome) {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Funcao> getFuncaos() {
        return funcaos;
    }

    public void setFuncaos(Collection<Funcao> funcaos) {
        this.funcaos = funcaos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + funcaos +
                '}';
    }
}
